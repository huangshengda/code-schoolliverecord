package com.codyy.slr.chat;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.User;
import com.codyy.slr.thread.ConfigThreadLocal;
import com.codyy.slr.util.TokenUtils;
import com.codyy.slr.util.UUIDUtils;
import com.codyy.slr.vo.ChatVo;

@ServerEndpoint(value = "/chat/{resourceId}/{token}")
public class ChatRoomAnnotation {

	private static final Logger log = Logger.getLogger("ChatRoomAnnotation");

	private static final Map<String, ChatRoomAnnotation> connections = new ConcurrentHashMap<String, ChatRoomAnnotation>();
	private static final Map<String, Session> resIdUserIdToClientMap = new ConcurrentHashMap<String, Session>();
	private static final Map<String, String> resIdtokenToAgentMap = new ConcurrentHashMap<String, String>();
	// 统计每个资源在线聊天人数
	private static final Map<String, AtomicInteger> resourceIdCountMap = new ConcurrentHashMap<String, AtomicInteger>();

	private Session session;

	private User user;

	@OnOpen
	public void start(Session session, @PathParam(value = "resourceId") String resourceId, @PathParam(value = "token") String token) throws Exception {
		String agent = ConfigThreadLocal.getVal();
		User user = getUser(token, agent);
		if (!userHasExist(user)) {
			throw new Exception();
		}

		this.user = user;
		this.session = session;

		if (resIdUserIdToClientMap.get(concatKey(resourceId, user.getUserId())) == null) {
			connections.put(user.getUserId(), this);

			if (resourceIdCountMap.get(resourceId) == null) {
				resourceIdCountMap.put(resourceId, new AtomicInteger(0));
			}
			// 自增一
			resourceIdCountMap.get(resourceId).incrementAndGet();
		}
		resIdUserIdToClientMap.put(concatKey(resourceId, user.getUserId()), session);
		resIdtokenToAgentMap.put(concatKey(resourceId, token), agent);

		log.info("start--connections:" + connections.size());
		log.info("start--resIdUserIdToClientMap:" + resIdUserIdToClientMap.size());
		log.info("start--resIdtokenToAgentMap:" + resIdtokenToAgentMap.size());

		ChatVo vo = new ChatVo(UUIDUtils.getUUID(), user.getRealname(), "加入聊天", resourceIdCountMap.get(resourceId), false, false,
				String.valueOf(new Date().getTime()));

		broadcast(vo, resourceId);

	}

	@OnClose
	public void end(@PathParam(value = "resourceId") String resourceId, @PathParam(value = "token") String token) {
		connections.remove(user.getUserId());
		resIdUserIdToClientMap.remove(concatKey(resourceId, user.getUserId()));
		resIdtokenToAgentMap.remove(concatKey(resourceId, token));

		log.info("end--connections:" + connections.size());
		log.info("end--resIdUserIdToClientMap:" + resIdUserIdToClientMap.size());
		log.info("end--resIdtokenToAgentMap:" + resIdtokenToAgentMap.size());

		int nowNum = 0;
		if (resourceIdCountMap.get(resourceId) != null) {
			nowNum = resourceIdCountMap.get(resourceId).decrementAndGet();
			if (nowNum <= 0) {
				resourceIdCountMap.remove(resourceId);
			}
		}
		ChatVo vo = new ChatVo(UUIDUtils.getUUID(), user.getRealname(), "离开聊天", resourceIdCountMap.get(resourceId), false, false,
				String.valueOf(new Date().getTime()));
		broadcast(vo, resourceId);
	}

	@OnMessage
	public void incoming(String messageJsonObj, @PathParam(value = "resourceId") String resourceId, @PathParam(value = "token") String token) throws Exception {

		ChatVo vo = JSONObject.parseObject(messageJsonObj, ChatVo.class);

		if (StringUtils.isEmpty(vo.getId())) {
			vo.setId(UUIDUtils.getUUID());
			vo.setAuthor(user.getRealname());
			vo.setDelFlag(false);
			vo.setDelAuth(false);
			vo.setOnlineCount(resourceIdCountMap.get(resourceId));
		} else {
			vo.setDelFlag(true);
		}

		broadcast(vo, resourceId);
	}

	@OnError
	public void onError(Throwable t) throws Throwable {
		log.error(("Chat Error: " + t.toString()));
	}

	private void broadcast(ChatVo vo, String resourceId) {
		Collection<ChatRoomAnnotation> connectionsList = connections.values();
		for (ChatRoomAnnotation client : connectionsList) {
			try {
				synchronized (client) {
					if (resIdUserIdToClientMap.get(concatKey(resourceId, client.user.getUserId())) != null) { // 判断是否在同一个房间

						String userType = client.user.getUserType();
						if (Constants.ADMIN.equalsIgnoreCase(userType) || Constants.SUPER_ADMIN.equalsIgnoreCase(userType)) {
							vo.setDelAuth(true);
						}
						(resIdUserIdToClientMap.get(concatKey(resourceId, client.user.getUserId()))).getBasicRemote().sendText(JSONObject.toJSONString(vo));
					}

				}
			} catch (IOException e) {
				e.printStackTrace();
				try {
					client.session.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

	}

	private String concatKey(String resourceId, String userId) {
		return resourceId + "_" + userId;
	}

	private User getUser(String token, String agent) {
		try {
			return TokenUtils.getUserFromCache(token, agent);
		} catch (ExecutionException e) {
			e.printStackTrace();
			return null;
		}
	}

	private boolean userHasExist(User user) {
		if (user == null || "0".equals(user.getUserId())) {
			return false;
		}
		return true;
	}

}
