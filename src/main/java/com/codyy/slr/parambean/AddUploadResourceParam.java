package com.codyy.slr.parambean;

import com.codyy.slr.entity.Resource;

/**
 * 
 * @Description: 添加资源参数 
 * @author huangshengda  
 * @date 2016年12月6日   
 *
 */
public class AddUploadResourceParam {

	private String resNickName;
	private String resName; // UUID+资源后缀
	private String subjectId;
	private String classlevelIds; // 年级id字符串 ","隔开
	private String author; // 主讲老师
	private String thumbName;// 封面:UUID+图片后缀
	private long size;

	public Resource toResource() {
		Resource resource = new Resource();
		resource.setSubjectId(this.subjectId);
		resource.setAuthor(this.author);
		resource.setResourceName(this.resNickName);
		resource.setSize(this.size);
		return resource;
	}

	public String getResNickName() {
		return resNickName;
	}

	public void setResNickName(String resNickName) {
		this.resNickName = resNickName;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getClasslevelIds() {
		return classlevelIds;
	}

	public void setClasslevelIds(String classlevelIds) {
		this.classlevelIds = classlevelIds;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getThumbName() {
		return thumbName;
	}

	public void setThumbName(String thumbName) {
		this.thumbName = thumbName;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

}
