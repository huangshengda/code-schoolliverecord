package com.codyy.slr.parambean;

/**
 * 搜索资源参数
 * @author huangshengda
 *
 */
public class SearchResourceParam {

	private String classlevelId;
	private String subjectId;
	private String sourceType;
	private String resourceNameKey;
	private String authorKey;
	private String createUserId;
	private String orderBy;
	private String orderType;
	
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
	public String getSourceType() {
		return sourceType;
	}
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	public String getResourceNameKey() {
		return resourceNameKey;
	}
	public void setResourceNameKey(String resourceNameKey) {
		this.resourceNameKey = resourceNameKey;
	}
	public String getAuthorKey() {
		return authorKey;
	}
	public void setAuthorKey(String authorKey) {
		this.authorKey = authorKey;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	
}
