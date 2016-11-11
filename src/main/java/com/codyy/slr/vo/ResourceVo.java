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
	private String classlevelName;
	private String subjectName;
	private String author;
	private String thumbPath;
	private String storePath;
	private int viewCnt;
	private String creatName;

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
				+ resourceName + ", classlevelName=" + classlevelName
				+ ", subjectName=" + subjectName + ", author=" + author
				+ ", thumbPath=" + thumbPath + ", storePath=" + storePath
				+ ", viewCnt=" + viewCnt + "]";
	}

	public String getCreatName() {
		return creatName;
	}

	public void setCreatName(String creatName) {
		this.creatName = creatName;
	}

}
