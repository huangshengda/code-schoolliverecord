package com.codyy.slr.entity;

import java.util.Date;

/**
 * 
 * @Description: 资源评论Bean 
 * @author huangshengda  
 * @date 2016年12月6日   
 *
 */
public class ResComment {
	private String resourceCommentId;

	private String resourceId;

	private String commentUserId;

	private String commentContent;

	private String parentCommentId;

	private String replyToUserId;

	private Date createTime;

	private boolean delAuth = false;

	public boolean isDelAuth() {
		return delAuth;
	}

	public void setDelAuth(boolean delAuth) {
		this.delAuth = delAuth;
	}

	public String getResourceCommentId() {
		return resourceCommentId;
	}

	public void setResourceCommentId(String resourceCommentId) {
		this.resourceCommentId = resourceCommentId == null ? null : resourceCommentId.trim();
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId == null ? null : resourceId.trim();
	}

	public String getCommentUserId() {
		return commentUserId;
	}

	public void setCommentUserId(String commentUserId) {
		this.commentUserId = commentUserId == null ? null : commentUserId.trim();
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent == null ? null : commentContent.trim();
	}

	public String getParentCommentId() {
		return parentCommentId;
	}

	public void setParentCommentId(String parentCommentId) {
		this.parentCommentId = parentCommentId == null ? null : parentCommentId.trim();
	}

	public String getReplyToUserId() {
		return replyToUserId;
	}

	public void setReplyToUserId(String replyToUserId) {
		this.replyToUserId = replyToUserId == null ? null : replyToUserId.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
