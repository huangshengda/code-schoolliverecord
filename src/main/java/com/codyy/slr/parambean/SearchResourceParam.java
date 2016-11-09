package com.codyy.slr.parambean;

/**
 * 搜索资源参数
 * @author huangshengda
 *
 */
public class SearchResourceParam {

	private String classlevelId;
	private String subjectId;
	private String key;
	private String createUserId;
	private String orderBy;
	private String orderType;
	
	
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
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
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
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
