package com.codyy.slr.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.dao.ResourceMapper;
import com.codyy.slr.entity.Resource;
import com.codyy.slr.entity.User;
import com.codyy.slr.parambean.AddResourceParam;
import com.codyy.slr.util.HostConfigUtils;
import com.codyy.slr.util.UUIDUtils;
import com.codyy.slr.vo.HomeLiveVo;
import com.codyy.slr.vo.ResourceVo;

@Service
public class ResourceService {

	@Autowired
	private ResourceMapper resourceMapper;

	public boolean addResource(AddResourceParam param, String createUserId) {
		boolean flag = true;
		Resource resource = param.toResource();
		String resourceId = UUIDUtils.getUUID();
		resource.setResourceId(resourceId);
		resource.setCreateUserId(createUserId);
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
	
	public boolean addLiveResource(AddResourceParam param,String liveResourceId, String livePath) {
		boolean flag = true;
		Resource resource = param.toResource();
		resource.setResourceId(liveResourceId);
		resource.setCreateTime(new Date());
		resource.setSourceType(Constants.RECORD);
		resource.setViewCnt(0L);
		resource.setLivingFlag(Constants.Y);
		resource.setLivingPath(livePath);

		int num = resourceMapper.addResource(resource);
		if (num == 1) {
			String[] classlevelIdList = param.getClasslevelIds().split(",");
			List<Map<String, String>> paramList = new ArrayList<Map<String, String>>();
			for (String string : classlevelIdList) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("resourceId", liveResourceId);
				map.put("classlevelId", string);
				paramList.add(map);
			}
			int ResClsNum = resourceMapper.addResIdClslevelIdList(paramList);
			if (ResClsNum != paramList.size()) {
				flag = false;
			}
		} else {
			flag = false;
		}
		return flag;
	}

	// 依据资源ID逻辑删除资源
	public int delResByResId(HttpServletRequest req, String resourceId) {
		User user = (User) req.getAttribute("user");
		
		Resource res = new Resource();
		res.setResourceId(resourceId);
		res.setDeleteUserId(user.getUserId());
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
			for (ResourceVo resourceVo : list) {
				resourceVo.setOpt(Constants.VIEW_EDIT_DELETE);
				resourceVo.setThumbPath(null);
			}
		}
		page.setData(list);
		return page;
	}

	// 获取我的课程资源列表
	public Page getMyResourcePageList(HttpServletRequest req, Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = (User) req.getAttribute("user");
		map.put("createUserId", user.getUserId());
		page.setMap(map);

		List<ResourceVo> list = resourceMapper.getResourcePageList(page);
		String contextpath = HostConfigUtils.getHost(req)+"/download/img";
		if (list.size() >= 1) {
			for (ResourceVo resourceVo : list) {
				resourceVo.setOpt(Constants.DELETE);
				resourceVo.setThumbPath(contextpath + resourceVo.getThumbPath());
			}
		}
		page.setData(list);
		return page;
	}

	// 根据资源ID获取资源
	public ResourceVo getResource(HttpServletRequest req, String resourceId) {
		String contextpath = HostConfigUtils.getHost(req);
		
		ResourceVo resVo = resourceMapper.getResource(resourceId);
		
		if(resVo != null){
			resVo.setThumbPath(contextpath + "/download/img" + resVo.getThumbPath());
			if (resVo.getLivingFlag().equals("N")) {
				resVo.setStorePath(contextpath + "/download/" + resVo.getSourceType() + resVo.getStorePath());
			}
		}
		
		return resVo;
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
	
	public boolean updateLiveResourceLivingPath(String resourceId){
		return resourceMapper.updateLiveResourceLivingPath(resourceId) == 1;
	}
	
	public List<String> getNotFinishLiveResIds() {
		return resourceMapper.getNotFinishLiveResIds();
	}
}
