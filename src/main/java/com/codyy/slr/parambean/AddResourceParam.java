package com.codyy.slr.parambean;

import com.alibaba.druid.util.StringUtils;
import com.codyy.slr.entity.Resource;

/**
 * 
 * @Description: 添加资源参数 
 * @author huangshengda  
 * @date 2016年12月6日   
 *
 */
public class AddResourceParam {

	private String resourceName;
	private String subjectId;
	private String classlevelIds; // 年级id字符串 ","隔开
	private String author; // 主讲老师
	private String thumbPath;// 封面路径
	private String storePath;// 存储路径
	private long size;

	public boolean validate() {
		String resNameRegEx = "[a-zA-Z0-9\u4E00-\u9FA5]{1,20}";// 中文 字母 数字

		String authorRegEx = "[a-zA-Z0-9\u4E00-\u9FA5]{1,10}";// 中文 字母 数字

		if (StringUtils.isEmpty(resourceName) || !resourceName.matches(resNameRegEx)) {
			return false;
		}

		if (StringUtils.isEmpty(author) || !author.matches(authorRegEx)) {
			return false;
		}

		if (StringUtils.isEmpty(classlevelIds)) {
			return false;
		}

		return true;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getStorePath() {
		return storePath;
	}

	public void setStorePath(String storePath) {
		this.storePath = storePath;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
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

	public String getThumbPath() {
		return thumbPath;
	}

	public void setThumbPath(String thumbPath) {
		this.thumbPath = thumbPath;
	}

	public Resource toResource() {
		Resource resource = new Resource();
		resource.setSubjectId(this.subjectId);
		resource.setAuthor(this.author);
		resource.setResourceName(this.resourceName);
		resource.setThumbPath(this.thumbPath);
		resource.setStorePath(this.storePath);
		return resource;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AddResourceParam [resourceName=");
		builder.append(resourceName);
		builder.append(", subjectId=");
		builder.append(subjectId);
		builder.append(", classlevelIds=");
		builder.append(classlevelIds);
		builder.append(", author=");
		builder.append(author);
		builder.append(", thumbPath=");
		builder.append(thumbPath);
		builder.append("]");
		return builder.toString();
	}

}
