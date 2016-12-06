package com.codyy.slr.entity;

import java.util.Date;
import java.util.List;

import com.codyy.slr.constant.Constants;

public class Subject {
    private String subjectId;

    private String subjectName;

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

	public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId == null ? null : subjectId.trim();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
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