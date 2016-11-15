package com.codyy.slr.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.common.page.Page;
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

	public boolean addResource(AddResourceParam param) {
		boolean flag = true;
		Resource resource = param.toResource();
		String resourceId = UUIDUtils.getUUID();
		resource.setResourceId(resourceId);
		resource.setCreateTime(new Date());
		resource.setSourceType(Constants.UPLOAD);
		resource.setViewCnt(0L);
		resource.setLivingFlag(Constants.N);

		int num = resourceMapper.addResource(resource);
		if (num == 1) {
			String[] classlevelIdList = param.getClasslevelIds().split(",");
			List<Map<String, String>> paramList = new ArrayList<Map<String, String>>();
			for (String string : classlevelIdList) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("resourceId", resourceId);
				map.put("classlevelId", string);
				paramList.add(map);
			}
			int num1 = resourceMapper.addResIdClslevelIdList(paramList);
			if (num1 != paramList.size()) {
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;
	}

	public void delResByResId(String resourceId) {
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

	// 获取资源信息
	public Page getResourcePageList(Page page) {
		List<ResourceVo> list = resourceMapper.getResourcePageList(page);
		if (list.size() >= 1) {
			Map<String, Object> map = page.getMap();
			if (map != null && !map.isEmpty()) {
				Object userId = map.get("createUserId");
				Object sourceType = map.get("sourceType");
				//判断用户ID是否为空,不为空则为查询数据赋值删除操作
				if (userId != null && StringUtils.isNotBlank(userId.toString())) {
					for(ResourceVo resourceVo : list){
						resourceVo.setOpt(Constants.DELETE);
					}
				}
				//判断资源类型是否为空,不为空则为查询数据赋值查看、编辑、删除操作
				if (sourceType != null && StringUtils.isNotBlank(sourceType.toString())) {
					for(ResourceVo resourceVo : list){
						resourceVo.setOpt(Constants.VIEW_EDIT_DELETE);
					}
				}
			}
		}
		page.setData(list);
		return page;
	}
	
	Resource getResourceById(String resourceId){
		return resourceMapper.getResourceById(resourceId);
	}
}
