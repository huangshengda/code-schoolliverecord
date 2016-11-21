package com.codyy.slr.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@RequestMapping(value = "/img/{imgPath}")
	public void getImg(HttpServletRequest req, HttpServletResponse res,
			@PathVariable(value="imgPath") String imgPath) {
		
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
	
	@RequestMapping(value = "/video/{type}/{videoPath}")
	public void getVideo(HttpServletRequest req, HttpServletResponse res,
			@PathVariable(value="type") String type, @PathVariable(value="videoPath") String videoPath) {
		
		try {
			if (type.equals("live")){
				commonsService.sendFileAsResponse(req, res, videoPath, Constants.LIVE_PATH);
			} else if (type.equals("upload")){
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
}
