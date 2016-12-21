package com.codyy.slr.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.dao.ResCommentMapper;
import com.codyy.slr.entity.ResComment;
import com.codyy.slr.util.DateUtils;
import com.codyy.slr.util.MapUtils;
import com.codyy.slr.vo.ResCommentVo;

/**
 * 评论service
 * @author huangshengda
 *
 */
@Service
public class ResCommentService {

	@Autowired
	private ResCommentMapper commentDao;

	/**
	 * 获取一个资源的评论
	 * @param page
	 * @return
	 */
	public Page getResCommentPageList(Page page) {
		/**
		 * 获取一级评论
		 */
		List<ResCommentVo> list = commentDao.getResCommentPageList(page);
		String userId = page.getMap().get("userId").toString();
		formatDateAndSetDelFun(list, userId);
		List<String> commentIdList = new ArrayList<String>();
		for (ResCommentVo comment : list) {
			// 是否有删除权限
			if (comment.getCommentUserId().equals(page.getMap().get("userId"))) {
				comment.setDelAuth(true);
			}
			commentIdList.add(comment.getResourceCommentId());
		}

		/**
		 * 将二级评论根据一级评论的id分组
		 */
		List<ResCommentVo> subList = getSubResCommentList(commentIdList, userId);
		Map<String, List<ResCommentVo>> groupListMap = MapUtils.newHashMap();
		for (ResCommentVo comment : subList) {
			// 是否有删除权限
			if (comment.getCommentUserId().equals(page.getMap().get("userId"))) {
				comment.setDelAuth(true);
			}
			MapUtils.groupValue(groupListMap, comment.getParentCommentId(), comment);
		}

		/**
		 * 一级评论中注入二级评论
		 */
		for (ResCommentVo comment : list) {
			if (groupListMap.containsKey(comment.getResourceCommentId())) {
				List<ResCommentVo> childrenCommentList = groupListMap.get(comment.getResourceCommentId());
				comment.setChildrenCommentSize(childrenCommentList.size());
				// 二级评论设计显示前5条
				/*if (childrenCommentList.size() > 5) {
					childrenCommentList = childrenCommentList.subList(0, 5);
				}*/
				comment.setChildrenCommentList(childrenCommentList);
			} else {
				comment.setChildrenCommentList(new ArrayList<ResCommentVo>());
			}
		}

		page.setData(list);
		return page;
	}

	/**
	 * 根据一级评论获取二级评论
	 */
	public List<ResCommentVo> getSubResCommentList(List<String> commentIdList, String userId) {
		if (commentIdList == null || commentIdList.size() == 0) {
			return new ArrayList<ResCommentVo>();
		}
		List<ResCommentVo> subList = commentDao.getSubResCommentList(commentIdList);
		formatDateAndSetDelFun(subList, userId);
		return subList;
	}

	public Page getSubResCommentPageList(Page page) {
		List<ResCommentVo> list = commentDao.getSubResCommentPageList(page);
		page.setData(list);
		return page;
	}

	/**
	 * 添加评论
	 */
	public boolean addResComment(ResComment comment) {
		return commentDao.insert(comment) == 1;
	}

	/**
	 * 删除评论
	 */
	public void deleteResComment(ResComment comment) {
		List<ResCommentVo> subList = commentDao.getSubResCommentList(Arrays.asList(comment.getResourceCommentId()));
		List<String> commentIdList = new ArrayList<String>();
		for (ResCommentVo view : subList) {
			commentIdList.add(view.getResourceCommentId());
		}

		commentIdList.add(comment.getResourceCommentId());

		commentDao.delBatchComment(commentIdList);
	}

	public ResCommentVo getCommentByKeyId(String commentId) {
		return commentDao.getCommentByKeyId(commentId);
	}

	/**
	 * 时间格式化,生成头像路径
	 */
	private void formatDateAndSetDelFun(List<ResCommentVo> list, String userId) {
		for (ResCommentVo view : list) {
			if (userId.equalsIgnoreCase(view.getCommentUserId())) {
				view.setOpt(Constants.DELETE);
			}
			view.setCreateTimeStr(DateUtils.format(view.getCreateTime(), "yyyy-MM-dd HH:mm"));
		}
	}

	public int getResCommentCount(String resDetailId) {
		return commentDao.getResCommentCount(resDetailId);
	}

	public Page getAllResCommentPageList(Page page) {
		List<ResCommentVo> list = commentDao.getAllResCommentPageList(page);
		page.setData(list);
		return page;
	}

}
