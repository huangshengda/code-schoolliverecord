package com.codyy.slr.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.User;
import com.codyy.slr.vo.ReturnVoOne;

@Controller("/font/path")
public class FrontPathController {

	@RequestMapping("demond")
	@ResponseBody
	public ReturnVoOne<Map<String, String>> getDemondPath(HttpServletRequest req) {
		Map<String, String> map = new HashMap<>();
		ReturnVoOne<Map<String, String>> one = new ReturnVoOne<Map<String, String>>();
		try {
			User user = (User) req.getAttribute("user");
			map.put("token", user.getToken());
			map.put("url", Constants.FRONT_DEMOND_PATH);
			one.setData(map);
		} catch (Exception e) {
			one.setCode(Constants.FAILED);
			e.printStackTrace();
		}
		return one;
	}

	@RequestMapping("live")
	@ResponseBody
	public ReturnVoOne<Map<String, String>> getLivePath(HttpServletRequest req) {
		Map<String, String> map = new HashMap<>();
		ReturnVoOne<Map<String, String>> one = new ReturnVoOne<Map<String, String>>();
		try {
			User user = (User) req.getAttribute("user");
			map.put("token", user.getToken());
			map.put("url", Constants.LIVE_PATH);
			one.setData(map);
		} catch (Exception e) {
			one.setCode(Constants.FAILED);
			e.printStackTrace();
		}
		return one;
	}

	@RequestMapping("upload")
	@ResponseBody
	public ReturnVoOne<Map<String, String>> getUploadPath(HttpServletRequest req) {
		Map<String, String> map = new HashMap<>();
		ReturnVoOne<Map<String, String>> one = new ReturnVoOne<Map<String, String>>();
		try {
			User user = (User) req.getAttribute("user");
			map.put("token", user.getToken());
			map.put("url", Constants.UPLOAD_PATH);
			one.setData(map);
		} catch (Exception e) {
			one.setCode(Constants.FAILED);
			e.printStackTrace();
		}
		return one;
	}
}
