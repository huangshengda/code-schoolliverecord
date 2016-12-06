package com.codyy.slr.entity;

/**
 * 
 * @Description: 网站基础信息bean  
 * @author huangshengda  
 * @date 2016年12月6日   
 *
 */
public class BasicInfo {
	private String infoName;

	private String infoValue;

	public BasicInfo() {
		super();
	}

	public BasicInfo(String infoName, String infoValue) {
		super();
		this.infoName = infoName;
		this.infoValue = infoValue;
	}

	public String getInfoName() {
		return infoName;
	}

	public void setInfoName(String infoName) {
		this.infoName = infoName == null ? null : infoName.trim();
	}

	public String getInfoValue() {
		return infoValue;
	}

	public void setInfoValue(String infoValue) {
		this.infoValue = infoValue == null ? null : infoValue.trim();
	}
}
