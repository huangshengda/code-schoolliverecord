package com.codyy.slr.chat;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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

	private static final Set<ChatRoomAnnotation> connections = Collections.synchronizedSet(new HashSet<ChatRoomAnnotation>());
	// 统计每个资源在线聊天人数
	private static final Map<String, AtomicInteger> resourceIdCountMap = new ConcurrentHashMap<String, AtomicInteger>();

	private Session session;

	private User user;

	private String resourceId;

	@OnOpen
	public void start(Session session, @PathParam(value = "resourceId") String resourceId, @PathParam(value = "token") String token) throws Exception {
		String agent = ConfigThreadLocal.getVal();
		User user = getUser(token, agent);
		if (!userHasExist(user)) {
			throw new Exception();
		}

		this.user = user;
		this.session = session;
		this.resourceId = resourceId;

		connections.add(this);

		if (resourceIdCountMap.get(resourceId) == null) {
			resourceIdCountMap.put(resourceId, new AtomicInteger(0));
		}
		// 自增一
		resourceIdCountMap.get(resourceId).incrementAndGet();

		log.info("start--connections:" + connections.size());
		log.info("start--resourceIdCountMap:" + resourceIdCountMap.size());

		ChatVo vo = new ChatVo(UUIDUtils.getUUID(), user.getRealname(), "加入聊天", resourceIdCountMap.get(resourceId), false, false,
				String.valueOf(new Date().getTime()));

		broadcast(vo, resourceId);

	}

	@OnClose
	public void end(@PathParam(value = "resourceId") String resourceId, @PathParam(value = "token") String token) {
		connections.remove(this);

		int nowNum = 0;
		if (resourceIdCountMap.get(resourceId) != null) {
			nowNum = resourceIdCountMap.get(resourceId).decrementAndGet();
			if (nowNum <= 0) {
				resourceIdCountMap.remove(resourceId);
			}
		}
		ChatVo vo = new ChatVo(UUIDUtils.getUUID(), user.getRealname(), "离开聊天", resourceIdCountMap.get(resourceId), false, false,
				String.valueOf(new Date().getTime()));

		log.info("end--connections:" + connections.size());
		log.info("end--resourceIdCountMap:" + resourceIdCountMap.size());

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

		log.info("incoming--connections:" + connections.size());
		log.info("incoming--resourceIdCountMap:" + resourceIdCountMap.size());

		broadcast(vo, resourceId);
	}

	@OnError
	public void onError(Throwable t) throws Throwable {
		log.error(("Chat Error: " + t.toString()));
	}

	private void broadcast(ChatVo vo, String resourceId) {
		Set<ChatRoomAnnotation> connectionsList = connections;
		for (ChatRoomAnnotation client : connectionsList) {
			try {
				synchronized (client) {
					vo.setDelAuth(false);
					if (client.resourceId.equals(resourceId)) {
						String userType = client.user.getUserType();
						if (Constants.ADMIN.equalsIgnoreCase(userType) || Constants.SUPER_ADMIN.equalsIgnoreCase(userType)) {
							vo.setDelAuth(true);
						}
						client.session.getBasicRemote().sendText(JSONObject.toJSONString(vo));
					}

				}
			} catch (IOException e) {
				log.error(e.toString());
				try {
					client.session.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

	}

	private User getUser(String token, String agent) {
		try {
			return TokenUtils.getUserFromCache(token, agent);
		} catch (ExecutionException e) {
			log.error(e.toString());
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
