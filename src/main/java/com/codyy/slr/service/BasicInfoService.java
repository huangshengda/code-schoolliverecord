package com.codyy.slr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.dao.BasicInfoMapper;
import com.codyy.slr.entity.BasicInfo;
import com.codyy.slr.parambean.BasicInfoParam;

/**
 * 
 * @author huangshengda
 *
 */
@Service
public class BasicInfoService {
	
	@Autowired
	private BasicInfoMapper basicInfoMapper;
	
	public boolean updateBasicInfo(BasicInfoParam param) {
		
		BasicInfo info = new BasicInfo("title",param.getTitle());
		BasicInfo info1 = new BasicInfo("logoPath",param.getLogoPath());
		BasicInfo info2 = new BasicInfo("buttomMsg",param.getButtomMsg());
		List<BasicInfo> list = new ArrayList<BasicInfo>();
		list.add(info);
		list.add(info1);
		list.add(info2);
		return basicInfoMapper.updateBasicInfo(list) == 1;
	}
	
	public List<BasicInfo> getBasicInfo(){
		return basicInfoMapper.getBasicInfo();
	}
}
