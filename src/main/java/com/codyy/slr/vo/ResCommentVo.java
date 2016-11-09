package com.codyy.slr.vo;

import java.util.List;

import com.codyy.slr.entity.ResComment;

public class ResCommentVo extends ResComment{
	/**
	 * 发布人名称
	 */
	private String userName;
    
	/**
	 * 用户头像
	 */
    private String headPic;
    
    /**
     * 图片地址
     */
    private String serverAddress; 
    
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

	public String getReplyToUserName() {
		return replyToUserName;
	}

	public void setReplyToUserName(String replyToUserName) {
		this.replyToUserName = replyToUserName;
	}

	public List<ResCommentVo> getChildrenCommentList() {
		return childrenCommentList;
	}

	public void setChildrenCommentList(List<ResCommentVo> childrenCommentList) {
		this.childrenCommentList = childrenCommentList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
}
