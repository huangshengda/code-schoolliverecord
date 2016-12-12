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

	private String author;

	private String msg;

	/**
	 * 在线人数
	 */
	private AtomicInteger onlineCount;

	/**
	 * 是否删除信息 true false
	 */
	private boolean delFlag;

	/**
	 * 删除权限  true false
	 */
	private boolean delAuth;

	private String timestamp;

	public ChatVo() {
		super();
	}

	public ChatVo(String id, String author, String msg, AtomicInteger onlineCount, boolean delFlag, boolean delAuth, String timestamp) {
		super();
		this.id = id;
		this.author = author;
		this.msg = msg;
		this.onlineCount = onlineCount;
		this.delFlag = delFlag;
		this.delAuth = delAuth;
		this.timestamp = timestamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public AtomicInteger getOnlineCount() {
		return onlineCount;
	}

	public void setOnlineCount(AtomicInteger onlineCount) {
		this.onlineCount = onlineCount;
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

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
