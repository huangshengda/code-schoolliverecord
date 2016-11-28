package com.codyy.slr.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.codyy.slr.util.ConfigUtils;
import com.codyy.slr.util.UploadUtil;
import com.codyy.slr.vo.ReturnVoOne;

@Controller
public class UploadAndDownload {
	
	
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping("image/upload")
	public ReturnVoOne  imageUpload(@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam(value = "sequence", required = true) String sequence ,HttpServletRequest request){
		if(file == null){
			return new ReturnVoOne(0,"文件内容为空");
		}
		
		String fileName = file.getOriginalFilename();
		File targetFile = new File(ConfigUtils.getValue("img.path") ,UploadUtil.createFilename(fileName));
		
	//	saveFile = UploadUtil.createFile(UploadUtil.getImagePath(), suffix);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
				file.transferTo(targetFile);
				// 文件类型
				String type = "." + fileName.substring(fileName.lastIndexOf(".") + 1);
				// 文件路径
				String url =  request.getServerName()+ "/image/" + file.getOriginalFilename();
	
				// 拼接返回对象
				String result = "{\"name\":\"" + targetFile.getName() + "\", \"originalName\": \"" + fileName + "\", \"size\": "
						+ targetFile.length() + ", \"state\": \"" + "SUCCESS" + "\", \"type\": \"" + type+", \"sequence\": " + sequence
						+ "\", \"url\": \"" + url + "\"}";
				result = result.replaceAll("\\\\", "\\\\");
	
				// 返回
				return new ReturnVoOne(1,result);
			}catch (Exception e) {
				return new ReturnVoOne(0,"上传失败");
			}
		
	}
	
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping("video/upload")
	public ReturnVoOne  videoUpload(@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam(value = "sequence", required = true) String sequence ,HttpServletRequest request){
		if(file == null){
			return new ReturnVoOne(0,"文件内容为空");
		}
		
		String fileName = file.getOriginalFilename();
		File targetFile = new File(ConfigUtils.getValue("img.path") ,UploadUtil.createFilename(fileName));
		
	//	saveFile = UploadUtil.createFile(UploadUtil.getImagePath(), suffix);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
				file.transferTo(targetFile);
				// 文件类型
				String type = "." + fileName.substring(fileName.lastIndexOf(".") + 1);
				// 文件路径
				String url =  request.getServerName()+ "/image/" + file.getOriginalFilename();
	
				// 拼接返回对象
				String result = "{\"name\":\"" + targetFile.getName() + "\", \"originalName\": \"" + fileName + "\", \"size\": "
						+ targetFile.length() + ", \"state\": \"" + "SUCCESS" + "\", \"type\": \"" + type+", \"sequence\": " + sequence
						+ "\", \"url\": \"" + url + "\"}";
				result = result.replaceAll("\\\\", "\\\\");
	
				// 返回
				return new ReturnVoOne(1,result);
			}catch (Exception e) {
				return new ReturnVoOne(0,"上传失败");
			}
		
	}
	
	
	
}
