package com.codyy.slr.entity;

import java.util.Date;
import java.util.List;

import com.codyy.slr.constant.Constants;

/**
 * 
 * @Description: 年级bean  
 * @author huangshengda  
 * @date 2016年12月6日   
 *
 */
public class Classlevel {
	private String classlevelId;

	private String classlevelName;

	private Integer sort;

	private String deleteFlag;

	private Date deleteTime;

	private Date createTime;

	private List<String> opt;

	public List<String> getOpt() {
		return opt;
	}

	public void setOpt(List<String> opt) {
		this.opt = Constants.EDIT_DELETE;
	}

	public String getClasslevelId() {
		return classlevelId;
	}

	public void setClasslevelId(String classlevelId) {
		this.classlevelId = classlevelId == null ? null : classlevelId.trim();
	}

	public String getClasslevelName() {
		return classlevelName;
	}

	public void setClasslevelName(String classlevelName) {
		this.classlevelName = classlevelName == null ? null : classlevelName.trim();
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
	}

	public Date getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Date deleteTime) {
		this.deleteTime = deleteTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
