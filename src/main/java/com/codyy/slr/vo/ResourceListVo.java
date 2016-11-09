package com.codyy.slr.vo;

/**
 * 首页点播资源VO
 * @author huangshengda
 *
 */
public class ResourceListVo {

	private String resourceId;
	private String resourceName;
	private String classleveName;
	private String subjectName;
	private String author;
	private int viewCnt;
	
	
	
	public ResourceListVo() {
		super();
	}
	
	public ResourceListVo(String resName, String classleveName, String subjectName, String author, int viewCnt,
			String thumbPath) {
		super();
		this.resourceName = resName;
		this.classleveName = classleveName;
		this.subjectName = subjectName;
		this.author = author;
		this.viewCnt = viewCnt;
		this.thumbPath = thumbPath;
	}
	
	
	
	public String getResId() {
		return resourceId;
	}
	public void setResId(String resId) {
		this.resourceId = resId;
	}
	private String thumbPath;
	
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
	
	
	
}
