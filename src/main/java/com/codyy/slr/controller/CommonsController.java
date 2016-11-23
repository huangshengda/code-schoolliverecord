package com.codyy.slr.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.service.CommonsService;

/**
 * File Description      : 公共请求：图片、视频流下载
 * Author                : GuangY
 * Create Date           : 2016/11/17
 * Reviewed By           :
 * Reviewed Date         :
 * Modified By           :
 * Modified Date         :
 * Comments              :
 * CopyRight             : COPYRIGHT(c) www.codyy.com   All Rights Reserved(2016)
 * *******************************************************************************************
 */

@Controller
@RequestMapping("/download")
public class CommonsController {
	
	@Autowired
	private CommonsService commonsService;
	
	/**
	 * 获取图片
	 * 
	 * @return
	 */
	@RequestMapping(value = "/img/**")
	public void getImg(HttpServletRequest req, HttpServletResponse res) {
		String imgPath = extractPathFromPattern(req);
		try {
			commonsService.sendFileAsResponse(req, res, imgPath, Constants.IMG_PATH);
		} catch (Exception e) {
			try {
				res.sendError(404);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取视频流
	 * @param req
	 * @param res
	 * @param videoPath
	 */
	@RequestMapping(value = "/video/{type}/**")
	public void getVideo(HttpServletRequest req, HttpServletResponse res, @PathVariable(value="type") String type) {
		String videoPath = extractPathFromPattern(req);
		
		try {
			if (type.equals("RECORD")){
				commonsService.sendFileAsResponse(req, res, videoPath, Constants.LIVE_PATH);
			} else if (type.equals("UPLOAD")){
				commonsService.sendFileAsResponse(req, res, videoPath, Constants.UPLOAD_PATH);
			}
		} catch (Exception e) {
			try {
				res.sendError(404);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	// 把指定URL后的字符串全部截断当成参数
	// 这么做是为了防止URL中包含中文或者特殊字符（/等）时，匹配不了的问题
	private static String extractPathFromPattern(final HttpServletRequest request)
	{
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String bestMatchPattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
		return new AntPathMatcher().extractPathWithinPattern(bestMatchPattern, path);
	}
}
