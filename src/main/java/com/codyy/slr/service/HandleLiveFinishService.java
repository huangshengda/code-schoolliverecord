package com.codyy.slr.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.Resource;
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
			similarFileList= FileUtils.findSimilarFile(similarFileList, dir, liveResourceId+".*");
		} catch (IOException e) {
			log.error("LiveResourceId = " + liveResourceId + ": 查找相似文件失败");
			e.printStackTrace();
		}
		
		String storePath = null;//存储路径
		String thumbPath = null;//封面路径
		long size = 0;//资源大小
		if(CollectionUtils.isEmpty(similarFileList)){
			
			log.error("LiveResourceId = " + liveResourceId + ": 查找相似文件数为０");
		}else{
			//3文件排序
			FileUtils.sortFileByCreateTime(similarFileList);
			log.info("LiveResourceId = " + liveResourceId + ": 合并文件开始.");
			//3合并文件
			log.info("LiveResourceId = " + liveResourceId + ": 合并文件结束.");
			
			//4移动文件
			log.info("LiveResourceId = " + liveResourceId + ": 移动文件开始.");
			log.info("LiveResourceId = " + liveResourceId + ": 移动文件结束.");
			//size = 
			//FileUtils.copyFile(oriFile, desFile);
			
			
			//5删除文件
			
			//6截图
			
			//7移动截图
		}
		
		//8将存储路径 (视频 图片)直播状态 更新到数据库 
		Resource res = new Resource();
		res.setStorePath(storePath);
		res.setThumbPath(thumbPath);
		res.setSize(size);
		res.setLivingFlag(Constants.N);
		boolean updateFlag = resourceService.updateFinishLiveRes(res);
		log.info("update liveResource info, and result is " + (updateFlag == true ? "success" : "fail") + "." );
		
		log.info("finishLive end.");
	}
}
