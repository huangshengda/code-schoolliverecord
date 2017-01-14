package com.codyy.slr.vo;

import com.codyy.slr.util.doc.annotation.ExcelColumn;
import com.codyy.slr.util.doc.annotation.ExcelHeader;

@ExcelHeader(headerName = "用户列表")
public class UserExportModel {
	@ExcelColumn(columnName = "用户名")
	private String username;
	@ExcelColumn(columnName = "姓名")
	private String realname;
	@ExcelColumn(columnName = "角色")
	private String userType;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

}
