package com.codyy.slr.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.dao.BasicInfoMapper;
import com.codyy.slr.entity.BasicInfo;
import com.codyy.slr.parambean.DirInfo;
import com.codyy.slr.util.FileUtils;
import com.codyy.slr.vo.BasicInfoVo;

/**
 * 
 * @Description: 基本信息Service  
 * @author huangshengda  
 * @date 2016年12月2日   
 *
 */
@Service
public class BasicInfoService {

	@Autowired
	private BasicInfoMapper basicInfoMapper;

	/**
	 * 
	 * @Description: 更新基础信息  
	 * @param param
	 * @return
	 *
	 */
	public boolean updateBasicInfo(BasicInfoVo param, boolean thumbFlag) {

		try {
			List<BasicInfo> list = new ArrayList<BasicInfo>();

			if (thumbFlag) {
				// 1.创建图片文件夹
				DirInfo imageDirInfo = FileUtils.creatDir(new Date(), Constants.IMG_PATH);
				// 2.移动图片
				FileUtils.moveFile(Constants.TEMP + Constants.PATH_SEPARATOR + param.getLogoPath(),
						imageDirInfo.getAbsPath() + Constants.PATH_SEPARATOR + param.getLogoPath());

				BasicInfo info1 = new BasicInfo("logoPath", imageDirInfo.getRelPath() + Constants.PATH_SEPARATOR + param.getLogoPath());
				list.add(info1);
			}

			BasicInfo info = new BasicInfo("title", param.getTitle());
			BasicInfo info2 = new BasicInfo("buttomMsg", param.getButtomMsg());
			list.add(info);
			list.add(info2);

			return basicInfoMapper.updateBasicInfo(list) == 1;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public BasicInfoVo getBasicInfo() {
		BasicInfoVo param = new BasicInfoVo();
		List<BasicInfo> list = basicInfoMapper.getBasicInfo();
		for (BasicInfo info : list) {
			if ("title".equalsIgnoreCase(info.getInfoName())) {
				param.setTitle(info.getInfoValue());
			} else if ("logoPath".equalsIgnoreCase(info.getInfoName())) {
				String logoPath = info.getInfoValue();
				if (logoPath.startsWith("/public")) {
					param.setLogoPath(Constants.ROOT_SERVER + logoPath);
				} else {
					param.setLogoPath(Constants.ROOT_SERVER + "/download/img" + Constants.PATH_SEPARATOR + Constants.IMG_REAL + logoPath);
				}
			} else {
				param.setButtomMsg(info.getInfoValue());
			}
		}

		return param;
	}
}
