package com.codyy.slr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.dao.ResourceMapper;
import com.codyy.slr.vo.HomeLiveVo;
import com.codyy.slr.vo.ResourceVo;

@Service
public class ResourceService {

	@Autowired
	private ResourceMapper resourceMapper;

	// 获取所有直播课程信息
	public List<HomeLiveVo> getHomeLiveList() {
		return resourceMapper.getHomeLiveList();
	}

	// 获取最新上传的8节课程(按上传时间降序排序)
	public List<ResourceVo> getHomeResourceList() {
		return resourceMapper.getHomeResourceList();
	}
	
	//获取资源信息
	public Page getResourcePageList(Page page){
		List<ResourceVo> list = resourceMapper.getResourcePageList(page);
		page.setData(list);
		return page;
	}
	
	public boolean addResource(){
		return true;
	}
}
