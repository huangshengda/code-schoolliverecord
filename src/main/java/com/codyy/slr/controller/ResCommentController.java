package com.codyy.slr.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.ResComment;
import com.codyy.slr.entity.User;
import com.codyy.slr.service.ResCommentService;
import com.codyy.slr.util.MapUtils;
import com.codyy.slr.util.MySqlKeyWordUtils;
import com.codyy.slr.vo.ResCommentVo;
import com.codyy.slr.vo.ReturnVoList;
import com.codyy.slr.vo.ReturnVoOne;

/**
 * 资源评论
 * @author huangshengda
 *
 */
@Controller
public class ResCommentController {

	@Autowired
	private ResCommentService resCommentService;

	
	/**
	 * 添加资源评论
	 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping("/resource/comment/add")
	public ReturnVoOne addResComment(ResComment resComment) {
		ReturnVoOne returnVoOne = new ReturnVoOne();
		try {
			// 校验参数
			if (!resComment.validate()) {
				returnVoOne.setCode(Constants.FAILED);
				returnVoOne.equals("参数不合法");
				return returnVoOne;
			}
			boolean flag = resCommentService.addResComment(resComment);
			if(!flag){
				returnVoOne.setCode(Constants.FAILED);
				returnVoOne.setMsg("添加评论失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
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
	@RequestMapping("/resource/comment/delete")
	public ReturnVoOne deleteResComment(ResComment resComment) {
		ReturnVoOne returnVoOne = new ReturnVoOne();
		try {
			resCommentService.deleteResComment(resComment);
		} catch (Exception e) {
			returnVoOne.setCode(Constants.FAILED);
			returnVoOne.setMsg("删除评论失败");
		}
		return returnVoOne;
	}
	
	/**
	 * 获取资源评论(一级评论,二级评论前五条)
	 */
	@ResponseBody
	@RequestMapping("/resource/comment/list")
	public ReturnVoList<ResCommentVo> getResCommentPageList(Page page, String resourceId,HttpServletRequest req) {
		User user =  (User) req.getAttribute("user");
		ReturnVoList<ResCommentVo> returnVoList = new ReturnVoList<ResCommentVo>();
		try {
			Map<String, Object> map = MapUtils.newHashMap();
			map.put("resourceId", resourceId);
			map.put("userId", user.getUserId());
			page.setMap(map);
			page= resCommentService.getResCommentPageList(page);
			returnVoList = new ReturnVoList<ResCommentVo>(page);
		} catch (Exception e) {
			e.printStackTrace();
			returnVoList.setCode(Constants.FAILED);
			returnVoList.setMsg("操作失败");
		}
		return returnVoList;
	}
	
	/**
	 * 获取资源二级评论
	 */
	@ResponseBody
	@RequestMapping("/resource/comment/subComment/list")
	public ReturnVoList<ResCommentVo> getbResSuCommentPageList(Page page,String parentCommentId){
		ReturnVoList<ResCommentVo> returnVoList = new ReturnVoList<ResCommentVo>();
		try {
			Map<String,Object> map =  MapUtils.newHashMap();
			map.put("parentCommentId", parentCommentId);
			page.setMap(map);
			page= resCommentService.getSubResCommentPageList(page);
			returnVoList = new ReturnVoList<ResCommentVo>(page);
		} catch (Exception e) {
			e.printStackTrace();
			returnVoList.setCode(Constants.FAILED);
			returnVoList.setMsg("操作失败");
		}
		return returnVoList;
	}
	
	
	/**
	 * 获取资源评论(所有评论)
	 */
	@ResponseBody
	@RequestMapping("/base/resource/comment/list")
	public ReturnVoList<ResCommentVo> getAllResCommentPageList(Page page, String keywords,String realname) {
		int code = Constants.SUCCESS;
		String msg = "获取成功";
		Map<String, Object> map = MapUtils.newHashMap();
		map.put("keywords",MySqlKeyWordUtils.MySqlKeyWordReplace(keywords));
		map.put("realname",MySqlKeyWordUtils.MySqlKeyWordReplace(realname));
		page.setMap(map);
		try {
			page= resCommentService.getAllResCommentPageList(page);
		} catch (Exception e) {
			code = Constants.FAILED;
			msg = "获取评论失败";
			e.printStackTrace();
			return new ReturnVoList<ResCommentVo>(code,msg,null);
		}
		ReturnVoList<ResCommentVo> returnVoList = new ReturnVoList<ResCommentVo>(page,code,msg);
		return returnVoList;
	}
	
}
