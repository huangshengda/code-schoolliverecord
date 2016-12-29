package com.codyy.slr.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.service.CommonsService;

/**
 * 
 * @Description: 公共请求：图片、视频流下载 
 * @author huangshengda  
 * @date 2016年12月17日   
 *
 */

@Controller
@RequestMapping("/download")
public class CommonsController {

	private static final Logger log = Logger.getLogger(CommonsController.class);

	@Autowired
	private CommonsService commonsService;

	/**
	 * 获取图片
	 * 
	 * @return
	 */
	@RequestMapping(value = "/img/{type}/**")
	public void getImg(HttpServletRequest req, HttpServletResponse res, @PathVariable(value = "type") String type) {
		String imgPath = extractPathFromPattern(req);
		try {
			if (type.equalsIgnoreCase(Constants.IMG_TEMP)) {
				commonsService.sendFileAsResponse(req, res, imgPath, Constants.TEMP);
			} else if (type.equalsIgnoreCase(Constants.IMG_REAL)) {
				commonsService.sendFileAsResponse(req, res, imgPath, Constants.IMG_PATH);
			}
		} catch (Exception e) {
			try {
				res.sendError(404);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			log.error(e.toString());
		}
	}

	/**
	 * 获取视频流
	 * @param req
	 * @param res
	 * @param videoPath
	 */
	@RequestMapping(value = "/video/{type}/**")
	public void getVideo(HttpServletRequest req, HttpServletResponse res, @PathVariable(value = "type") String type) {
		String videoPath = extractPathFromPattern(req);

		try {
			if (type.equalsIgnoreCase(Constants.RECORD)) {
				commonsService.sendFileAsResponse(req, res, videoPath, Constants.LIVE_PATH);
			} else if (type.equalsIgnoreCase(Constants.UPLOAD)) {
				commonsService.sendFileAsResponse(req, res, videoPath, Constants.UPLOAD_PATH);
			}
		} catch (Exception e) {
			try {
				res.sendError(404);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			log.error(e.toString());
		}
	}

	// 把指定URL后的字符串全部截断当成参数
	// 这么做是为了防止URL中包含中文或者特殊字符（/等）时，匹配不了的问题
	private static String extractPathFromPattern(final HttpServletRequest request) {
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String bestMatchPattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
		return new AntPathMatcher().extractPathWithinPattern(bestMatchPattern, path);
	}
}
