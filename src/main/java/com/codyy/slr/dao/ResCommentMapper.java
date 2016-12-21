package com.codyy.slr.dao;

import java.util.List;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.entity.ResComment;
import com.codyy.slr.vo.ResCommentVo;

public interface ResCommentMapper {

	int deleteByPrimaryKey(String resourceCommentId);

	int insert(ResComment record);

	ResComment selectByPrimaryKey(String resourceCommentId);

	List<ResCommentVo> getResCommentPageList(Page page);

	List<ResCommentVo> getSubResCommentList(List<String> list);

	List<ResCommentVo> getSubResCommentPageList(Page page);

	ResCommentVo getCommentByKeyId(String commentId);

	int getResCommentCount(String resourceId);

	List<ResCommentVo> getAllResCommentPageList(Page page);

	void delBatchComment(List<String> commentIds);

}
