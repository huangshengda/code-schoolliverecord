package com.codyy.slr.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

/**
 * File Description      : 公共方法:图片、视频流下载
 * Author                : GuangY
 * Create Date           : 2016/11/18
 * Reviewed By           :
 * Reviewed Date         :
 * Modified By           :
 * Modified Date         :
 * Comments              :
 * CopyRight             : COPYRIGHT(c) www.codyy.com   All Rights Reserved(2016)
 * *******************************************************************************************
 */
@Service
public class CommonsService {
	
	/**
	 * 把文件作为流返回给客服端
	 * @throws IOException 
	 */
	public static void sendFileAsResponse(HttpServletResponse response, File file) throws IOException{
		if (file !=null && file.exists()) {
			InputStream input = null;
			try {
				response.addHeader("Cache-Control", "max-age=864000");
				input = new FileInputStream(file);
				StreamUtils.copy(input, response.getOutputStream());
				input.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				if(input!=null){
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				if(input!=null){
					input.close();
				}
			} finally {
				if(input!=null){
					input.close();
				}
			}
		}
	}
	
	public String buildFilePath(String filePath){
		
		return "";
	}
}
