package com.codyy.slr.vo;

import java.util.List;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.ResComment;

/**
 * 
 * @Description: 资源评论VO  
 * @author huangshengda  
 * @date 2016年12月6日   
 *
 */
public class ResCommentVo extends ResComment {
	/**
	 * 发布人名称
	 */
	private String userName;

	/**
	 * 回复谁
	 */
	private String replyToUserName;

	/**
	 * 用于时间显示
	 */
	private String createTimeStr;

	/**
	 * 存放二级评论
	 */
	private List<ResCommentVo> childrenCommentList;

	/**
	 * 二级评论数量
	 */
	private int childrenCommentSize;

	/**
	 * 操作权限
	 */
	@SuppressWarnings("unused")
	private List<String> opt;

	private String realName;

	private String resourceName;

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public List<String> getOpt() {
		return opt = Constants.DELETE;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public void setOpt(List<String> opt) {
		this.opt = opt;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReplyToUserName() {
		return replyToUserName;
	}

	public void setReplyToUserName(String replyToUserName) {
		this.replyToUserName = replyToUserName;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public List<ResCommentVo> getChildrenCommentList() {
		return childrenCommentList;
	}

	public void setChildrenCommentList(List<ResCommentVo> childrenCommentList) {
		this.childrenCommentList = childrenCommentList;
	}

	public int getChildrenCommentSize() {
		return childrenCommentSize;
	}

	public void setChildrenCommentSize(int childrenCommentSize) {
		this.childrenCommentSize = childrenCommentSize;
	}

}
