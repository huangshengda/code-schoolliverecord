package com.codyy.slr.vo;

/**
 * 资源VO
 * @author huangshengda
 *
 */
public class ResourceListVo {

	private String resourceId;
	private String resourceName;
	private String classleveName;
	private String subjectName;
	private String author;
	private String createUserName;
	private int viewCnt;
	private String thumbPath;
	
	
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

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
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
