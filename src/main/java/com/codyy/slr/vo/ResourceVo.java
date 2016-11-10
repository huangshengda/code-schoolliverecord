package com.codyy.slr.vo;

/**
 * 点播资源视图类
 * 
 * @author GuangY
 *
 */
public class ResourceVo {

	private String resourceId;
	private String resourceName;
	private String classleveName;
	private String subjectName;
	private String author;
	private String thumbPath;
	private String storePath;
	private int viewCnt;

	public ResourceVo() {
		super();
	}

	public String getResId() {
		return resourceId;
	}

	public void setResId(String resId) {
		this.resourceId = resId;
	}

	public String getResName() {
		return resourceName;
	}

	public void setResName(String resName) {
		this.resourceName = resName;
	}

	public String getClassleveName() {
		return classleveName;
	}

	public void setClassleveName(String classleveName) {
		this.classleveName = classleveName;
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

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getThumbPath() {
		return thumbPath;
	}

	public void setThumbPath(String thumbPath) {
		this.thumbPath = thumbPath;
	}

	public String getStorePath() {
		return storePath;
	}

	public void setStorePath(String storePath) {
		this.storePath = storePath;
	}

	@Override
	public String toString() {
		return "ResourceVo [resourceId=" + resourceId + ", resourceName="
				+ resourceName + ", classleveName=" + classleveName
				+ ", subjectName=" + subjectName + ", author=" + author
				+ ", thumbPath=" + thumbPath + ", storePath=" + storePath
				+ ", viewCnt=" + viewCnt + "]";
	}

}
