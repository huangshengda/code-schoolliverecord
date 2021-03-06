package com.codyy.slr.entity;

import java.util.Date;

/**
 * 
 * @Description: DMSServer地址bean  
 * @author huangshengda  
 * @date 2016年12月6日   
 *
 */
public class DmsServer {
	private String serverId;

	private String serverName;

	private String serverValue;

	private Date lastModifyTime;

	private Date createTime;

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId == null ? null : serverId.trim();
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName == null ? null : serverName.trim();
	}

	public String getServerValue() {
		return serverValue;
	}

	public void setServerValue(String serverValue) {
		this.serverValue = serverValue == null ? null : serverValue.trim();
	}
}
