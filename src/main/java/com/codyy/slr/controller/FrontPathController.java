package com.codyy.slr.controller;

import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.util.StringUtils;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.User;
import com.codyy.slr.util.TokenUtils;

@Controller
@RequestMapping("/front/path")
public class FrontPathController {

	@RequestMapping("demond")
	public String getDemondPath(HttpServletRequest req) {
		try {
			User user = getUser(req);
			if (user == null || "0".equals(user.getUserId())) {
				return Constants.FRONT_INDEX_PATH;
			} else {
				req.setAttribute("token", user.getToken());
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.FRONT_INDEX_PATH;
		}
		return Constants.FRONT_LIVE_PATH;
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
		} catch (Exception e) {
			e.printStackTrace();
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
		User user = TokenUtils.getUserFromCache(token + agent);
		return user;
	}
}
