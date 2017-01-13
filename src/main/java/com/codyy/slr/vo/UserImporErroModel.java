package com.codyy.slr.vo;

import com.codyy.slr.util.doc.annotation.ExcelColumn;
import com.codyy.slr.util.doc.annotation.ExcelHeader;

@ExcelHeader(headerName = "用户导入错误信息详情")
public class UserImporErroModel {

	@ExcelColumn(columnName = "用户名")
	private ValueBean userName;
	@ExcelColumn(columnName = "密码")
	private ValueBean password;
	@ExcelColumn(columnName = "姓名")
	private ValueBean realname;
	@ExcelColumn(columnName = "角色")
	private ValueBean userType;

	public ValueBean getUserName() {
		return userName;
	}

	public void setUserName(ValueBean userName) {
		this.userName = userName;
	}

	public ValueBean getPassword() {
		return password;
	}

	public void setPassword(ValueBean password) {
		this.password = password;
	}

	public ValueBean getRealname() {
		return realname;
	}

	public void setRealname(ValueBean realname) {
		this.realname = realname;
	}

	public ValueBean getUserType() {
		return userType;
	}

	public void setUserType(ValueBean userType) {
		this.userType = userType;
	}

}
