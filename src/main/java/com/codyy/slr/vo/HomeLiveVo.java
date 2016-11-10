package com.codyy.slr.vo;

/**
 * 直播课程视图类
 * 
 * @author GuangY
 *
 */
public class HomeLiveVo {

	private String resourceId;
	private String resourceName;
	private String classlevelName;
	private String subjectName;
	private String author;
	private String livingPath;

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

	public String getLivingPath() {
		return livingPath;
	}

	public void setLivingPath(String livingPath) {
		this.livingPath = livingPath;
	}

	@Override
	public String toString() {
		return "HomeLiveVo [resourceId=" + resourceId + ", resourceName="
				+ resourceName + ", classlevelName=" + classlevelName
				+ ", subjectName=" + subjectName + ", author=" + author
				+ ", livingPath=" + livingPath + "]";
	}

}
