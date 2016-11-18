package com.codyy.slr.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
