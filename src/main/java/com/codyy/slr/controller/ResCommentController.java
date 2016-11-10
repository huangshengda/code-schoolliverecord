package com.codyy.slr.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.ResComment;
import com.codyy.slr.service.ResCommentService;
import com.codyy.slr.util.MapUtil;
import com.codyy.slr.vo.ResCommentVo;
import com.codyy.slr.vo.ReturnVoList;
import com.codyy.slr.vo.ReturnVoOne;

/**
 * 资源评论
 * @author huangshengda
 *
 */
@Controller
@RequestMapping("resource/comment")
public class ResCommentController {

	@Autowired
	private ResCommentService resCommentService;

	
	/**
	 * 添加资源评论
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping("addResComment")
	public ReturnVoOne addResComment(ResComment resComment) {
		ReturnVoOne returnVoOne = new ReturnVoOne();
		boolean flag = resCommentService.addResComment(resComment);
		if(!flag){
			returnVoOne.setCode(Constants.FAILED);
			returnVoOne.setMsg("添加评论失败");
		}
		return returnVoOne;
	}
	
	/**
	 * 删除资源评论
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping("delResComment")
	public ReturnVoOne deleteResComment(ResComment resComment) {
		resCommentService.deleteResComment(resComment);
		return new ReturnVoOne();
	}
	
	/**
	 * 获取资源评论(一级评论,二级评论前五条)
	 */
	@ResponseBody
	@RequestMapping("getResCommentPageList")
	public ReturnVoList<ResCommentVo> getResCommentPageList(Page page, String resourceId) {
		Map<String, Object> map = MapUtil.newHashMap();
		map.put("resourceId", resourceId);
		page.setMap(map);
		page= resCommentService.getResCommentPageList(page);
		ReturnVoList<ResCommentVo> returnVoList = new ReturnVoList<ResCommentVo>(page);
		return returnVoList;
	}
	
	/**
	 * 获取资源二级评论
	 */
	@ResponseBody
	@RequestMapping("getResSubCommentPageList")
	public ReturnVoList<ResCommentVo> getbResSuCommentPageList(Page page,String parentCommentId){
		Map<String,Object> map =  MapUtil.newHashMap();
		map.put("parentCommentId", parentCommentId);
		page.setMap(map);
		page= resCommentService.getSubResCommentPageList(page);
		ReturnVoList<ResCommentVo> returnVoList = new ReturnVoList<ResCommentVo>(page);
		return returnVoList;
	}
	
	
}
