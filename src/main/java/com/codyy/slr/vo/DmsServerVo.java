package com.codyy.slr.vo;

import java.util.List;

import com.codyy.slr.constant.Constants;


public class DmsServerVo {
    private String serverId;

    private String serverName;

    private String serverValue;

    private List<String> opt;
    
    private int sort;
    
    
    public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public List<String> getOpt() {
		return (opt==null?Constants.EDIT_DELETE:opt) ;
	}

	public void setOpt(List<String> opt) {
		this.opt = opt;
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