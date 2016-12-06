package com.codyy.slr.vo;

import java.util.List;

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
	private String classlevelId;
	private String subjectName;
	private String subjectId;
	private String author;
	private String thumbPath;
	private String storePath;
	private int viewCnt;
	private String creatName;
	private String size;
	private String sourceType;
	private String livingFlag;
	private List<String> opt;

	public ResourceVo() {
		super();
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

	public String getCreatName() {
		return creatName;
	}

	public void setCreatName(String creatName) {
		this.creatName = creatName;
	}

	public List<String> getOpt() {
		return opt;
	}

	public void setOpt(List<String> opt) {
		this.opt = opt;
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

	public String getClasslevelId() {
		return classlevelId;
	}

	public void setClasslevelId(String classlevelId) {
		this.classlevelId = classlevelId;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getLivingFlag() {
		return livingFlag;
	}

	public void setLivingFlag(String livingFlag) {
		this.livingFlag = livingFlag;
	}

}
