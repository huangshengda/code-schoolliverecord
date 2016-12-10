package com.codyy.slr.vo;

import java.util.concurrent.atomic.AtomicInteger;

/**  
 * @Description: 在线聊天bean  
 * @author huangshengda  
 * @date 2016年12月10日   
 *  
*/
public class ChatVo {

	private String id;

	private String msg;

	/**
	 * 在线人数
	 */
	private AtomicInteger onlineCount;

	/**
	 * 删除权限 true false
	 */
	private boolean delFlag;

	/**
	 * 删除权限  true false
	 */
	private boolean delAuth;

	public ChatVo(String id, String msg, AtomicInteger onlineCount, boolean delFlag, boolean delAuth) {
		super();
		this.id = id;
		this.msg = msg;
		this.onlineCount = onlineCount;
		this.delFlag = delFlag;
		this.delAuth = delAuth;
	}

	public AtomicInteger getOnlineCount() {
		return onlineCount;
	}

	public void setOnlineCount(AtomicInteger onlineCount) {
		this.onlineCount = onlineCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isDelFlag() {
		return delFlag;
	}

	public void setDelFlag(boolean delFlag) {
		this.delFlag = delFlag;
	}

	public boolean isDelAuth() {
		return delAuth;
	}

	public void setDelAuth(boolean delAuth) {
		this.delAuth = delAuth;
	}

}
