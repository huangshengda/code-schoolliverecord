package com.codyy.slr.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.codyy.slr.constant.Constants;

public class User implements Serializable{

	private static final long serialVersionUID = 7883313984780094895L;

	private String userId;

    private String username;

    private String realname;

    private String password;

    private String userType;

    private String deleteFlag;

    private Date deleteTime;

    private Date createTime;
    
    private String token;
    
    private List<String> opt;
    
    
    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<String> getOpt() {
		return opt;
	}

	public void setOpt(List<String> opt) {
		this.opt = Constants.EDIT_DELETE;
	}

	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=");
		builder.append(userId);
		builder.append(", username=");
		builder.append(username);
		builder.append(", realname=");
		builder.append(realname);
		builder.append(", password=");
		builder.append(password);
		builder.append(", userType=");
		builder.append(userType);
		builder.append(", deleteFlag=");
		builder.append(deleteFlag);
		builder.append(", deleteTime=");
		builder.append(deleteTime);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", token=");
		builder.append(token);
		builder.append(", opt=");
		builder.append(opt);
		builder.append("]");
		return builder.toString();
	}
    
    
}