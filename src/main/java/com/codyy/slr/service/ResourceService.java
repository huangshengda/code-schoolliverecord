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
		resource.setSize(param.getSize());

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

	// 依据资源ID逻辑删除资源
	public int delResByResId(String resourceId) {
		Resource res = new Resource();
		res.setResourceId(resourceId);
		// TODO 缺少获取UserID的方法
		res.setDeleteUserId("");
		res.setDeleteTime(new Date());

		return resourceMapper.delResByResId(res);
	}

	// 获取所有直播课程信息
	public List<HomeLiveVo> getHomeLiveList() {
		return resourceMapper.getHomeLiveList();
	}

	// 获取资源列表
	public Page getResourcePageList(Page page) {
		List<ResourceVo> list = resourceMapper.getResourcePageList(page);
		if (list.size() >= 1) {
			Map<String, Object> map = page.getMap();
			if (map != null && !map.isEmpty()) {
				Object sourceType = map.get("sourceType");
				// 判断资源类型是否为空,不为空则为查询数据赋值查看、编辑、删除操作
				if (sourceType != null
						&& StringUtils.isNotBlank(sourceType.toString())) {
					for (ResourceVo resourceVo : list) {
						resourceVo.setOpt(Constants.VIEW_EDIT_DELETE);
					}
				}
			}
		}
		page.setData(list);
		return page;
	}

	// 获取我的课程资源列表
	public Page getMyResourcePageList(Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		// TODO 缺少获取userId方法
		map.put("createUserId", "userId");

		page.setMap(map);

		List<ResourceVo> list = resourceMapper.getResourcePageList(page);
		if (list.size() >= 1) {
			for (ResourceVo resourceVo : list) {
				resourceVo.setOpt(Constants.DELETE);
			}
		}
		page.setData(list);
		return page;
	}

	// 根据资源ID获取资源
	public ResourceVo getResource(String resourceId) {
		return resourceMapper.getResource(resourceId);
	}

	// 更新资源信息
	public boolean modifyResource(ResourceVo res) {
		boolean result = false;
		String resourceId = res.getResourceId();

		int delResult = resourceMapper.delResIDRClslevelID(resourceId);

		if (delResult == 1) {
			int mResult = resourceMapper.modifyResource(res);
			if (mResult == 1) {
				if (StringUtils.isNotBlank(res.getClasslevelId())) {
					String[] ids = res.getClasslevelId().split(",");
					List<Map<String, String>> list = new ArrayList<Map<String, String>>();
					for (String id : ids) {
						Map<String, String> map = new HashMap<String, String>();
						map.put("resourceId", resourceId);
						map.put("classlevelId", id);
						list.add(map);
					}
					int addResult = resourceMapper.addResIdClslevelIdList(list);
					if (addResult == list.size()) {
						result = true;
					}
				}
			}
		}
		return result;
	}
	
	public List<ResourceVo> getRecommendResourceList(Map<String,String> map){
		
		List<ResourceVo> list = resourceMapper.getRecommendResourceList(map);
		
		String resourceId = map.get("resourceId");
		
		List<ResourceVo> result = new ArrayList<ResourceVo>();
		
		for (ResourceVo resourceVo : list) {
			if(resourceVo.getResourceId().equals(resourceId)){
				continue;
			}
			if(result.size() > 5){
				break;
			}
			result.add(resourceVo);
		}
		return result;
	}
}
