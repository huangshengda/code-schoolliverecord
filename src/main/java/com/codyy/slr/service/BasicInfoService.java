package com.codyy.slr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.dao.BasicInfoMapper;
import com.codyy.slr.entity.BasicInfo;
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

		BasicInfo info = new BasicInfo("title", param.getTitle());
		BasicInfo info1 = new BasicInfo("logoPath", param.getLogoPath());
		BasicInfo info2 = new BasicInfo("buttomMsg", param.getButtomMsg());
		List<BasicInfo> list = new ArrayList<BasicInfo>();
		list.add(info);
		list.add(info1);
		list.add(info2);
		return basicInfoMapper.updateBasicInfo(list) == 1;
	}

	public List<BasicInfo> getBasicInfo() {
		return basicInfoMapper.getBasicInfo();
	}
}
