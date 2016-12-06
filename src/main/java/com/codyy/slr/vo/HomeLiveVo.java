package com.codyy.slr.vo;

/**
 * 
 * @Description: 直播课程视图类  
 * @author huangshengda  
 * @date 2016年12月6日   
 *
 */
public class HomeLiveVo {

	private String resourceId;
	private String resourceName;
	private String classlevelName;
	private String subjectName;
	private String author;

	public HomeLiveVo() {

	}

	public String getClasslevelName() {
		return classlevelName;
	}

	public void setClasslevelName(String classlevelName) {
		this.classlevelName = classlevelName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
}
