package com.codyy.slr.schedule;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import com.alibaba.druid.util.StringUtils;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.service.HandleLiveFinishService;
import com.codyy.slr.service.ResourceService;
import com.codyy.slr.util.FileUtils;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

/**
 * 直播服务
 * @author huangshengda
 *
 */
public class LiveSchedule {
	
	private static final Logger log = Logger.getLogger(LiveSchedule.class);
	
	private static final String dmsVideoPath = Constants.DMS_VIDEO_PATH;
	
	private ResourceService resourceService;
	
	private HandleLiveFinishService handleLiveFinishService;
	
	/**
	 * 结束直播
	 */
	public void finishLive(){
		log.info("finishLive start");
		//1 查找为结束的直播课程
		List<String> liveResourceIdList = resourceService.getNotFinishLiveResIds();
		System.out.println(liveResourceIdList);
		if(CollectionUtils.isEmpty(liveResourceIdList)){
			log.info("liveResourceIdList is empty.");
		}else{
			for (String liveResourceId : liveResourceIdList) {
				handleLiveFinishService.finishLive(liveResourceId, dmsVideoPath);
			}
		}
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
