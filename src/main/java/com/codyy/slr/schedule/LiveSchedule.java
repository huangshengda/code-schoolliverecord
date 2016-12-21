package com.codyy.slr.schedule;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.service.HandleLiveFinishService;
import com.codyy.slr.service.ResourceService;
import com.codyy.slr.util.FileUtils;

/**
 * 
 * @Description: 定时任务类  
 * @author huangshengda  
 * @date 2016年12月2日   
 *
 */
public class LiveSchedule {

	private static final Logger log = Logger.getLogger(LiveSchedule.class);

	private ResourceService resourceService;

	private HandleLiveFinishService handleLiveFinishService;

	/**
	 * 
	 * @Description: 结束直播课程 
	 *
	 */
	public void finishLive() {
		log.info("finishLive start");
		// 1 查找为结束的直播课程
		List<String> liveResourceIdList = resourceService.getNotFinishLiveResIds();
		log.info("结束课程：" + liveResourceIdList);
		if (CollectionUtils.isEmpty(liveResourceIdList)) {
			log.info("liveResourceIdList is empty.");
		} else {
			for (String liveResourceId : liveResourceIdList) {
				boolean flag = resourceService.updateLiveResourceLivingPath(liveResourceId);
				log.info("liveResourceId =" + liveResourceId + ":更新数据库,直播路径设置为空.结果为:" + (flag == true ? "success" : "fail"));
				handleLiveFinishService.finishLive(liveResourceId);

			}
		}
		log.info("finishLive end.");
	}

	/**
	 * 
	 * @Description: 删除temp目录下的文件  
	 *
	 */
	public void delTempFiles() {
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

	public HandleLiveFinishService getHandleLiveFinishService() {
		return handleLiveFinishService;
	}

	public void setHandleLiveFinishService(HandleLiveFinishService handleLiveFinishService) {
		this.handleLiveFinishService = handleLiveFinishService;

	}

}
