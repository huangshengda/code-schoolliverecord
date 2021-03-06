package com.codyy.slr.controller;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.User;
import com.codyy.slr.service.BasicInfoService;
import com.codyy.slr.util.StringUtils;
import com.codyy.slr.util.TokenUtils;
import com.codyy.slr.vo.BasicInfoVo;

/**
 * 
 * @Description: 返回前段路径  
 * @author huangshengda  
 * @date 2016年12月17日   
 *
 */
@Controller
@RequestMapping("/front/path")
public class FrontPathController {

	private static final Logger log = Logger.getLogger(FrontPathController.class);

	@Autowired
	private BasicInfoService basicInfoService;

	@RequestMapping("index")
	public void getIndex(HttpServletRequest req, HttpServletResponse response, String token) throws IOException {
		try {
			req.getSession().setAttribute("token", token);
		} catch (Exception e) {
			log.error("", e);
		}
		response.sendRedirect(Constants.ROOT_SERVER);
	}

	@RequestMapping("demond")
	public String getDemondPath(HttpServletRequest req) {
		try {
			User user = getUser(req);
			if (user == null || "0".equals(user.getUserId())) {
				return Constants.FRONT_INDEX_PATH;
			} else {
				req.setAttribute("token", user.getToken());
			}
			BasicInfoVo infoVo = basicInfoService.getBasicInfo();
			req.setAttribute("basicInfo", infoVo);
		} catch (Exception e) {
			log.error(e.toString());
			return Constants.FRONT_INDEX_PATH;
		}

		return Constants.FRONT_DEMOND_PATH;
	}

	@RequestMapping("live")
	public String getLivePath(HttpServletRequest req) {
		try {
			User user = getUser(req);
			if (user == null || "0".equals(user.getUserId())) {
				return Constants.FRONT_INDEX_PATH;
			} else {
				req.setAttribute("token", user.getToken());
			}
			BasicInfoVo infoVo = basicInfoService.getBasicInfo();
			req.setAttribute("basicInfo", infoVo);
		} catch (Exception e) {
			log.error(e.toString());
			return Constants.FRONT_INDEX_PATH;
		}
		return Constants.FRONT_LIVE_PATH;
	}

	@RequestMapping("editpwd")
	public String editPwd(HttpServletRequest req) {
		try {
			User user = getUser(req);
			if (user == null || "0".equals(user.getUserId())) {
				return Constants.FRONT_INDEX_PATH;
			} else {
				req.setAttribute("token", user.getToken());
			}
			BasicInfoVo infoVo = basicInfoService.getBasicInfo();
			req.setAttribute("basicInfo", infoVo);
		} catch (Exception e) {
			log.error(e.toString());
			return Constants.FRONT_INDEX_PATH;
		}
		return Constants.FRONT_DEITPWD_PATH;
	}

	@RequestMapping("upload")
	public String getUploadPath(HttpServletRequest req) {
		try {
			User user = getUser(req);
			if (user == null || "0".equals(user.getUserId())) {
				return Constants.FRONT_INDEX_PATH;
			} else {
				req.setAttribute("token", user.getToken());
			}
			BasicInfoVo infoVo = basicInfoService.getBasicInfo();
			req.setAttribute("basicInfo", infoVo);
		} catch (Exception e) {
			log.error(e.toString());
			return Constants.FRONT_INDEX_PATH;
		}
		return Constants.FRONT_UPLOAD_PATH;
	}

	private User getUser(HttpServletRequest req) throws ExecutionException {
		// 先从header中取token,如果没有再从参数中取
		String token = req.getHeader("token");
		if (StringUtils.isEmpty(token)) {
			token = req.getParameter("token");
		}

		String agent = req.getHeader("User-Agent");
		User user = TokenUtils.getUserFromCache(token, agent);
		return user;
	}
}
