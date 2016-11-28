package com.codyy.slr.schedule;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.service.ResourceService;
import com.codyy.slr.util.FileUtils;

/**
 * 直播服务
 * @author huangshengda
 *
 */
public class LiveSchedule {
	
	private static final Logger log = Logger.getLogger(LiveSchedule.class);
	
	private ResourceService resourceService;
	
	/**
	 * 结束直播
	 */
	public void finishLive(){
		log.info("finishLive start");
		//1 查找为结束的直播课程
		List<String> liveResourceIdList = resourceService.getNotFinishLiveResIds();
		System.out.println(liveResourceIdList);
		//1更新数据库将直播路径设置为空
		//resourceService.updateLiveResourceLivingPath(liveResourceId);
		//2查找文件
		
		//3合并文件
		
		//4移动文件
		
		//5删除文件
		
		//6将存储路径 直播状态更新到数据库
		log.info("finishLive end.");
	}

	/**
	 * 
	 * @return
	 */
	public void delTempFiles(){
		log.info("del directory start");
		try {
			FileUtils.delDirectory(Constants.TEMP);
		} catch (IOException e) {
			log.info("del file fail");
			e.printStackTrace();
		}
		log.info("del directory end.");
	}
	
	public ResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}
}
