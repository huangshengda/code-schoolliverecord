package com.codyy.slr.entity;

import java.util.Date;

/**
 * 
 * @Description: 资源bean 
 * @author huangshengda  
 * @date 2016年12月6日   
 *
 */
public class Resource {
	private String resourceId;

	private String resourceName;

	private String subjectId;

	private String author;

	private String thumbPath;

	private Long viewCnt;

	private String sourceType;

	private String storePath;

	private String livingPath;

	private String livingFlag;

	private String deleteFlag;

	private String deleteUserId;

	private Date deleteTime;

	private String createUserId;

	private String userId;

	private long size;

	private Date createTime;

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId == null ? null : resourceId.trim();
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName == null ? null : resourceName.trim();
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId == null ? null : subjectId.trim();
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author == null ? null : author.trim();
	}

	public String getThumbPath() {
		return thumbPath;
	}

	public void setThumbPath(String thumbPath) {
		this.thumbPath = thumbPath == null ? null : thumbPath.trim();
	}

	public Long getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(Long viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType == null ? null : sourceType.trim();
	}

	public String getStorePath() {
		return storePath;
	}

	public void setStorePath(String storePath) {
		this.storePath = storePath == null ? null : storePath.trim();
	}

	public String getLivingPath() {
		return livingPath;
	}

	public void setLivingPath(String livingPath) {
		this.livingPath = livingPath == null ? null : livingPath.trim();
	}

	public String getLivingFlag() {
		return livingFlag;
	}

	public void setLivingFlag(String livingFlag) {
		this.livingFlag = livingFlag == null ? null : livingFlag.trim();
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
	}

	public String getDeleteUserId() {
		return deleteUserId;
	}

	public void setDeleteUserId(String deleteUserId) {
		this.deleteUserId = deleteUserId == null ? null : deleteUserId.trim();
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId == null ? null : createUserId.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Resource [resourceId=" + resourceId + ", resourceName=" + resourceName + ", subjectId=" + subjectId + ", author=" + author + ", thumbPath="
				+ thumbPath + ", viewCnt=" + viewCnt + ", sourceType=" + sourceType + ", storePath=" + storePath + ", livingPath=" + livingPath
				+ ", livingFlag=" + livingFlag + ", deleteFlag=" + deleteFlag + ", deleteUserId=" + deleteUserId + ", deleteTime=" + deleteTime
				+ ", createUserId=" + createUserId + ", userId=" + userId + ", createTime=" + createTime + "]";
	}
}
