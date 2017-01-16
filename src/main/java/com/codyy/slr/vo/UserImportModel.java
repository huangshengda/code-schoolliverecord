package com.codyy.slr.vo;

import java.util.Date;

import com.codyy.slr.util.doc.annotation.ExcelColumn;

public class UserImportModel {
	private String userId;
	@ExcelColumn(columnName = "用户名")
	private String username;
	@ExcelColumn(columnName = "密码")
	private String password;
	@ExcelColumn(columnName = "姓名")
	private String realname;
	@ExcelColumn(columnName = "角色")
	private String userType;

	private Date createTime;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
