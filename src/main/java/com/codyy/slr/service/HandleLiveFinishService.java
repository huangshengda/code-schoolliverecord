package com.codyy.slr.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
	
	@Autowired
	private HandleVideoService handleVideoService;
	
	public void finishLive(String liveResourceId){
		
		String logPrefix = "LiveResourceId = " + liveResourceId + ": ";
		
		Date date = new Date();
		try {
			//1.更新数据库将直播路径设置为空
			boolean flag = resourceService.updateLiveResourceLivingPath(liveResourceId);
			log.info(logPrefix + " update livePath set null, and result is " + boolean2Str(flag));
			
			//2.查找文件
			List<File> similarFileList= FileUtils.findSimilarFile(new ArrayList<File>(), Constants.DMS_VIDEO_PATH, liveResourceId+".*");
			log.info(logPrefix +  ": similarFileList=" + similarFileList.toString());
			
			//3.生成视频文件夹
			Map<String,String> livePathMap = FileUtils.creatDir(date,Constants.LIVE_PATH);
			
			String absDirPathStr = livePathMap.get("absPath");//绝对路径 
			String relDirPathStr =  livePathMap.get("relPath");//相对路径
			
			String absFilePathStr = absDirPathStr + Constants.PATH_SEPARATOR + liveResourceId + Constants.VIDEO_FLV;//绝对路径文件
			String relFilePathStr = relDirPathStr + Constants.PATH_SEPARATOR + liveResourceId + Constants.VIDEO_FLV;//相对路径文件
			
			log.info(logPrefix + ": absFilePathStr=" + absFilePathStr);
			
			String storePath = null;//存储路径
			String thumbPath = null;//封面路径
			long size = 0;//资源大小
			if(CollectionUtils.isEmpty(similarFileList)){
				log.error(logPrefix + ": 查找相似文件数为０");
			}else{
				//4.文件排序
				FileUtils.sortFileByCreateTime(similarFileList);
				List<String> fileStrList = FileUtils.fileList2FileStrList(similarFileList);
				
				log.info(logPrefix + ": 合并文件开始.");
				//5.合并文件
				boolean concatFlag = handleVideoService.concatVideos(fileStrList, absFilePathStr);
				log.info(logPrefix + ": 合并文件结束. result: " + boolean2Str(concatFlag));
				
				storePath = relFilePathStr;
				
				//6.获取文件大小
				size = FileUtils.getFileSize(absFilePathStr);
				thumbPath = relFilePathStr;
				
				log.info(logPrefix + "开始截图");
				//7.生成图片文件夹
				Map<String,String> thumbPathMap = FileUtils.creatDir(date,Constants.IMG_PATH);
				//8.截图
				List<String> list = handleVideoService.getShotImgs(absFilePathStr, liveResourceId, 1, thumbPathMap.get("absPath"));
				thumbPath =  thumbPathMap.get("relPath")+ Constants.PATH_SEPARATOR +list.get(0);
				log.info(logPrefix + "截图路径 " + thumbPath);
			}
			
			//8将存储路径 (视频 图片)直播状态 更新到数据库 
			Resource res = new Resource();
			res.setResourceId(liveResourceId);
			res.setStorePath(storePath);
			res.setThumbPath(thumbPath);
			res.setSize(size);
			res.setLivingFlag(Constants.N);
			boolean updateFlag = resourceService.updateFinishLiveRes(res);
			log.info(logPrefix + "update liveResource info, and result is " + boolean2Str(updateFlag));
			
			log.info(logPrefix + "finishLive end.");
		} catch (Exception e) {
			e.printStackTrace();
			log.info(logPrefix + "finish fail.");
		}
		
	}
	
	private String boolean2Str(boolean flag){
		return flag == true ? "success" : "fail";
	}
	
}
