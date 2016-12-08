package com.codyy.slr.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.User;

@Controller
@RequestMapping("/front/path")
public class FrontPathController {

	@RequestMapping("demond")
	public String getDemondPath(HttpServletRequest req) {
		try {
			User user = (User) req.getAttribute("user");
			req.setAttribute("token", user.getToken());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Constants.FRONT_DEMOND_PATH;
	}

	@RequestMapping("live")
	public String getLivePath(HttpServletRequest req) {
		try {
			User user = (User) req.getAttribute("user");
			req.setAttribute("token", user.getToken());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Constants.FRONT_LIVE_PATH;
	}

	@RequestMapping("upload")
	public String getUploadPath(HttpServletRequest req) {
		try {
			User user = (User) req.getAttribute("user");
			req.setAttribute("token", user.getToken());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Constants.FRONT_UPLOAD_PATH;
	}

}
