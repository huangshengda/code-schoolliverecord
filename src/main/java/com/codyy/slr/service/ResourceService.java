package com.codyy.slr.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.dao.ResourceMapper;
import com.codyy.slr.entity.Resource;
import com.codyy.slr.parambean.AddResourceParam;
import com.codyy.slr.util.UUIDUtils;
import com.codyy.slr.vo.HomeLiveVo;
import com.codyy.slr.vo.ResourceVo;

@Service
public class ResourceService {

	@Autowired
	private ResourceMapper resourceMapper;
	
	
	
	public boolean addResource(AddResourceParam param){
		boolean flag = true;
		Resource resource = param.toResource();
		String resourceId = UUIDUtils.getUUID();
		resource.setResourceId(resourceId);
		resource.setCreateTime(new Date());
		resource.setSourceType(Constants.UPLOAD);
		resource.setViewCnt(0L);
		resource.setLivingFlag(Constants.N);
		
		int num =resourceMapper.addResource(resource);
		if(num == 1){
			String[] classlevelIdList = param.getClasslevelIds().split(",");
			List<Map<String,String>> paramList = new ArrayList<Map<String,String>>();
			for (String string : classlevelIdList) {
				Map<String,String> map = new HashMap<String,String>();
				map.put("resourceId", resourceId);
				map.put("classlevelId", string);
				paramList.add(map);
			}
			int num1 = resourceMapper.addResIdClslevelIdList(paramList);
			if(num1 != paramList.size()){
				flag = false;
			}
		}else{
			flag = false;
		}
		return flag;
	}
	
	public void delResByResId(String resourceId){
		resourceMapper.delResByResId(resourceId);
	}
	
	// 获取所有直播课程信息
	public List<HomeLiveVo> getHomeLiveList() {
		return resourceMapper.getHomeLiveList();
	}

	// 获取最新上传的8节课程(按上传时间降序排序)
	public List<ResourceVo> getHomeResourceList() {
		return resourceMapper.getHomeResourceList();
	}
}
