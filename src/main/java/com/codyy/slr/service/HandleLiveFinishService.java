package com.codyy.slr.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.Resource;
import com.codyy.slr.parambean.DirInfo;
import com.codyy.slr.thread.DelFileThread;
import com.codyy.slr.util.FileUtils;

@Service
public class HandleLiveFinishService {

	private static final Logger log = Logger.getLogger(HandleLiveFinishService.class);

	@Autowired
	private ResourceService resourceService;

	@Autowired
	private HandleVideoService handleVideoService;

	public boolean finishLive(String liveResourceId) {

		boolean finishSuccessFlag = false;

		String logPrefix = "LiveResourceId = " + liveResourceId + ": ";

		Date date = new Date();
		log.info(logPrefix + "finish start.");
		try {
			// 1.更新数据库将直播路径设置为空
			boolean flag = resourceService.updateLiveResourceLivingPath(liveResourceId);
			log.info(logPrefix + "更新数据库直播路径为null,更新结果:" + boolean2Str(flag));

			// 2.查找文件
			List<File> similarFileList = FileUtils.findSimilarFile(new ArrayList<File>(), Constants.DMS_VIDEO_PATH, liveResourceId + ".*");
			log.info(logPrefix + "similarFileList=" + similarFileList.toString());

			String storePath = null;// 存储路径
			String thumbPath = null;// 封面路径
			long size = 0;// 资源大小

			if (CollectionUtils.isEmpty(similarFileList)) {
				log.error(logPrefix + "查找相似文件数为０");
			} else {
				// 3.文件排序
				FileUtils.sortFileByCreateTime(similarFileList);
				List<String> fileStrList = FileUtils.fileListToFileStrList(similarFileList);

				// 4.生成视频文件夹
				DirInfo livePathInfo = FileUtils.creatDir(date, Constants.LIVE_PATH);

				String absDirPathStr = livePathInfo.getAbsPath();// 绝对路径
				String relDirPathStr = livePathInfo.getRelPath();// 相对路径

				String absFilePathStr = absDirPathStr + Constants.PATH_SEPARATOR + liveResourceId + Constants.VIDEO_FLV;// 绝对路径文件
				String relFilePathStr = relDirPathStr + Constants.PATH_SEPARATOR + liveResourceId + Constants.VIDEO_FLV;// 相对路径文件

				log.info(logPrefix + "absFilePathStr=" + absFilePathStr);

				// 5.合并文件
				log.info(logPrefix + "合并文件开始.");
				boolean concatFlag = false;
				int concatTimes = 0;
				while (concatTimes < Constants.CONCAT_VIDEO_TIMES && !concatFlag) {
					concatFlag = handleVideoService.concatVideos(fileStrList, absFilePathStr);
				}
				log.info(logPrefix + ": 合并文件结束. 合并第" + (concatTimes + 1) + "次,result: " + boolean2Str(concatFlag));

				if (concatFlag) {
					// 6.删除文件
					log.info(logPrefix + "删除视频开始.");
					DelFileThread delFileThread = new DelFileThread(fileStrList);
					new Thread(delFileThread).start();
					log.info(logPrefix + "删除视频结束.");

					storePath = relFilePathStr;
					// 7.获取文件大小
					size = FileUtils.getFileSize(absFilePathStr);

					thumbPath = relFilePathStr;// 赋值存储路径

					// 8.生成图片文件夹
					DirInfo thumbPathInfo = FileUtils.creatDir(date, Constants.IMG_PATH);
					log.info(logPrefix + "开始截图");

					// 9.截图
					int shotImgTimes = 0;
					boolean shotImgFlag = false;
					List<String> imgPathlist = null;
					while (shotImgTimes < Constants.SHOT_IMG_TIMES && !shotImgFlag) {
						imgPathlist = handleVideoService.getShotImgs(absFilePathStr, liveResourceId, 1, thumbPathInfo.getAbsPath());
						shotImgFlag = !CollectionUtils.isEmpty(imgPathlist);
					}
					if (shotImgFlag) {
						thumbPath = thumbPathInfo.getRelPath() + Constants.PATH_SEPARATOR + imgPathlist.get(0);
						finishSuccessFlag = true;
					}
					log.info(logPrefix + "截图第" + (shotImgTimes + 1) + ",图片 " + thumbPath);
				}

			}

			// 10将存储路径 (视频 图片)直播状态 更新到数据库
			Resource res = new Resource();
			res.setResourceId(liveResourceId);
			res.setStorePath(storePath);
			res.setThumbPath(thumbPath);
			res.setSize(size);
			res.setLivingFlag(Constants.N);
			boolean updateFlag = resourceService.updateFinishLiveRes(res);
			log.info(logPrefix + "更新数据库信息, and result is " + boolean2Str(updateFlag));

			log.info(logPrefix + "finishLive end.");
		} catch (Exception e) {
			e.printStackTrace();
			log.info(logPrefix + "finish fail.");
		}

		return finishSuccessFlag;
	}

	private String boolean2Str(boolean flag) {
		return flag == true ? "success" : "fail";
	}

}
