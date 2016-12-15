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
	public boolean updateBasicInfo(BasicInfoVo param) {

		try {
			// 1.创建图片文件夹
			DirInfo imageDirInfo = FileUtils.creatDir(new Date(), Constants.IMG_PATH);
			// 2.移动图片
			FileUtils.moveFile(Constants.TEMP + Constants.PATH_SEPARATOR + param.getLogoPath(),
					imageDirInfo.getAbsPath() + Constants.PATH_SEPARATOR + param.getLogoPath());

			BasicInfo info = new BasicInfo("title", param.getTitle());
			BasicInfo info1 = new BasicInfo("logoPath", imageDirInfo.getAbsPath() + Constants.PATH_SEPARATOR + param.getLogoPath());
			BasicInfo info2 = new BasicInfo("buttomMsg", param.getButtomMsg());
			List<BasicInfo> list = new ArrayList<BasicInfo>();
			list.add(info);
			list.add(info1);
			list.add(info2);

			return basicInfoMapper.updateBasicInfo(list) == 1;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<BasicInfo> getBasicInfo() {
		return basicInfoMapper.getBasicInfo();
	}
}
