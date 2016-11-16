package com.codyy.slr.dao;

import java.util.List;

import com.codyy.slr.entity.BasicInfo;

public interface BasicInfoMapper {
	
	int updateBasicInfo(List<BasicInfo> basicInfoList);
	
	List<BasicInfo> getBasicInfo();
}