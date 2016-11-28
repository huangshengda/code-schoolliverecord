package com.codyy.slr.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.util.FileUtils;

@Service
public class HandleLiveFinishService {
	
	private static final Logger log = Logger.getLogger(HandleLiveFinishService.class);
	
	@Autowired
	private ResourceService resourceService;
	
	public void finishLive(String liveResourceId,String dir){
		//1更新数据库将直播路径设置为空
		boolean flag = resourceService.updateLiveResourceLivingPath(liveResourceId);
		log.info("update livePath set null, and result is " + (flag == true ? "success" : "fail") + "." );
		List<File> similarFileList = new ArrayList<>();
		//2查找文件
		try {
			List<File> fileList= FileUtils.findSimilarFile(similarFileList, dir, liveResourceId+".*");
			//排序
			FileUtils.sortFileByCreateTime(fileList);
		} catch (IOException e) {
			log.error("LiveResourceId = " + liveResourceId + ": 查找相似文件失败");
			e.printStackTrace();
		}
		//3合并文件
		
		//4移动文件
		
		//5删除文件
		
		//6截图
		
		//7移动截图
		
		//8将存储路径 (视频 图片)直播状态 更新到数据库 
		log.info("finishLive end.");
	}
}
