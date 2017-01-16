package com.codyy.slr.vo;

/**
 * 
 * @Description: 网站基础信息请求参数 bean  
 * @author huangshengda  
 * @date 2016年12月2日   
 *
 */
public class BasicInfoVo {
	private String  title;
	private String logoPath;
	private String buttomMsg;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	public String getButtomMsg() {
		return buttomMsg;
	}
	public void setButtomMsg(String buttomMsg) {
		this.buttomMsg = buttomMsg;
	}
	
}
