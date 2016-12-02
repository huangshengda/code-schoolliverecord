package com.codyy.slr.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.util.ConfigUtils;
import com.codyy.slr.util.UploadUtil;
import com.codyy.slr.vo.ReturnVoOne;

@Controller
public class UploadAndDownloadController {
	
	
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping("image/upload")
	public ReturnVoOne  imageUpload(@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam(value = "filename", required = true) String filename,
			@RequestParam(value = "sequence", required = true) String sequence ,HttpServletRequest request){
		if(file == null){
			return new ReturnVoOne(0,"文件内容为空");
		}
		
		String fileName = file.getOriginalFilename();
		String suffix = filename.substring(filename.lastIndexOf('.'));
		File targetFile = new File(ConfigUtils.getValue("img.path") ,filename+suffix);
		
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
						+ "\"}";
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
		File targetFile = new File(ConfigUtils.getValue("temp") ,UploadUtil.createFilename(fileName));
		
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		try {
				file.transferTo(targetFile);
				// 文件类型
				String type = "." + fileName.substring(fileName.lastIndexOf(".") + 1);
	
				// 拼接返回对象
				String result = "{\"name\":\"" + targetFile.getName() + "\", \"originalName\": \"" + fileName + "\", \"size\": "
						+ targetFile.length() + ", \"state\": \"" + "SUCCESS" + "\", \"type\": \"" + type+", \"sequence\": " + sequence
						+ "\"}";
				result = result.replaceAll("\\\\", "\\\\");
				// 返回
				return new ReturnVoOne(1,result);
			}catch (Exception e) {
				return new ReturnVoOne(0,"上传失败");
			}
		
	}
	
	
	
	@ResponseBody
	@RequestMapping("getUploadProgress")
	public ReturnVoOne<Double>  getUploadProgress(@RequestParam(value = "filename", required = true) String filename,
			@RequestParam(value = "filesize", required = true) Integer filesize,
			@RequestParam(value = "sequence", required = true) String sequence ,HttpServletRequest request){
		Long per1 = 0l;
		Path dir = Paths.get(Constants.TEMP);
		
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir, filename + "*")){
			for(Path e : stream){
				per1 = e.toFile().length();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
			

			Double per = per1*1.0 / filesize*1.0 *100;
			
				return new ReturnVoOne<Double>(1,null,per);
		
	}
	
	
	
	
}