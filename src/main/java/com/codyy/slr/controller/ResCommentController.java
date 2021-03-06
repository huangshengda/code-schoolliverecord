package com.codyy.slr.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.codyy.slr.common.page.Page;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.ResComment;
import com.codyy.slr.entity.User;
import com.codyy.slr.service.ResCommentService;
import com.codyy.slr.service.UserService;
import com.codyy.slr.util.DateUtils;
import com.codyy.slr.util.MapUtils;
import com.codyy.slr.util.MySqlKeyWordUtils;
import com.codyy.slr.util.UUIDUtils;
import com.codyy.slr.vo.ResCommentVo;
import com.codyy.slr.vo.ReturnVoList;
import com.codyy.slr.vo.ReturnVoOne;

/**
 * 
 * @Description: 资源评论  
 * @author huangshengda  
 * @date 2016年12月6日   
 *
 */
@Controller
public class ResCommentController {

	private static final Logger log = Logger.getLogger(ResCommentController.class);

	@Autowired
	private ResCommentService resCommentService;

	@Autowired
	private UserService userService;

	/**
	 *  
	 * @Description: 添加评论  
	 * @param resComment
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("/resource/comment/add")
	public ReturnVoOne<ResCommentVo> addResComment(ResCommentVo resComment, HttpServletRequest req) {
		ReturnVoOne<ResCommentVo> returnVoOne = new ReturnVoOne<>();
		try {

			User user = (User) req.getAttribute("user");
			resComment.setCommentUserId(user.getUserId());
			resComment.setResourceCommentId(UUIDUtils.getUUID());
			resComment.setCreateTime(new Date());
			boolean flag = resCommentService.addResComment(resComment);
			if (flag) {
				resComment.setUserName(user.getRealname());
				resComment.setDelAuth(true);
				if (!StringUtils.isEmpty(resComment.getReplyToUserId()) && !"-1".equalsIgnoreCase(resComment.getReplyToUserId())) {
					User userReply = userService.selectByPrimaryKey(resComment.getReplyToUserId());
					resComment.setReplyToUserName(userReply.getRealname());
					resComment.setCreateTimeStr(DateUtils.format(resComment.getCreateTime(), "yyyy-MM-dd HH:mm"));
				}
				returnVoOne.setData(resComment);
			} else {
				returnVoOne.setCode(Constants.FAILED);
				returnVoOne.setMsg("添加评论失败");
			}
		} catch (Exception e) {
			log.error(e.toString());
			returnVoOne.setCode(Constants.FAILED);
			returnVoOne.setMsg("添加评论失败");
		}
		return returnVoOne;
	}

	/**
	 * 
	 * @Description: 删除评论  
	 * @param resComment
	 * @return
	 *
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
	 * 
	 * @Description: 获取资源评论(一级评论,二级评论)  
	 * @param page
	 * @param resourceId
	 * @param req
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("/resource/comment/list")
	public ReturnVoList<ResCommentVo> getResCommentPageList(Page page, String resourceId, HttpServletRequest req) {
		User user = (User) req.getAttribute("user");
		ReturnVoList<ResCommentVo> returnVoList = new ReturnVoList<ResCommentVo>();
		try {
			Map<String, Object> map = MapUtils.newHashMap();
			map.put("resourceId", resourceId);
			map.put("userId", user.getUserId());
			page.setMap(map);
			page = resCommentService.getResCommentPageList(page);
			returnVoList = new ReturnVoList<ResCommentVo>(page);
		} catch (Exception e) {
			log.error(e.toString());
			returnVoList.setCode(Constants.FAILED);
			returnVoList.setMsg("操作失败");
		}
		return returnVoList;
	}

	/**
	 * 
	 * @Description: 获取资源二级评论 
	 * @param page
	 * @param parentCommentId
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("/resource/comment/subComment/list")
	public ReturnVoList<ResCommentVo> getbResSuCommentPageList(Page page, String parentCommentId) {
		ReturnVoList<ResCommentVo> returnVoList = new ReturnVoList<ResCommentVo>();
		try {
			Map<String, Object> map = MapUtils.newHashMap();
			map.put("parentCommentId", parentCommentId);
			page.setMap(map);
			page = resCommentService.getSubResCommentPageList(page);
			returnVoList = new ReturnVoList<ResCommentVo>(page);
		} catch (Exception e) {
			log.error(e.toString());
			returnVoList.setCode(Constants.FAILED);
			returnVoList.setMsg("操作失败");
		}
		return returnVoList;
	}

	/**
	 * 
	 * @Description: 获取资源评论(所有评论)
	 * @param page
	 * @param keywords
	 * @param realname
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("/base/resource/comment/list")
	public ReturnVoList<ResCommentVo> getAllResCommentPageList(Page page, String keywords, String realname) {
		int code = Constants.SUCCESS;
		String msg = "获取成功";
		Map<String, Object> map = MapUtils.newHashMap();
		map.put("keywords", MySqlKeyWordUtils.MySqlKeyWordReplace(keywords));
		map.put("realname", MySqlKeyWordUtils.MySqlKeyWordReplace(realname));
		page.setMap(map);
		try {
			page = resCommentService.getAllResCommentPageList(page);
		} catch (Exception e) {
			code = Constants.FAILED;
			msg = "获取评论失败";
			log.error(e.toString());
			return new ReturnVoList<ResCommentVo>(code, msg, null);
		}
		ReturnVoList<ResCommentVo> returnVoList = new ReturnVoList<ResCommentVo>(page, code, msg);
		return returnVoList;
	}

}
