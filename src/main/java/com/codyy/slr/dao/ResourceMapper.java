package com.codyy.slr.dao;

import java.util.List;
import java.util.Map;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.entity.Resource;
import com.codyy.slr.vo.HomeLiveVo;
import com.codyy.slr.vo.ResourceVo;

public interface ResourceMapper {
	// 获取所有直播课程信息
	List<HomeLiveVo> getHomeLiveList();

	// 获取资源信息
	List<ResourceVo> getResourcePageList(Page page);

	/**
	 * 添加资源
	 * 
	 * @param record
	 * @return
	 */
	int addResource(Resource record);

	/**
	 * 批量插入资源和年级关系数据
	 * 
	 * @param list
	 * @return
	 */
	int addResIdClslevelIdList(List<Map<String, String>> list);

	/**
	 * 删除资源(逻辑删除)
	 * 
	 * @param resourceId
	 * @return
	 */

	int delResByResId(Resource res);

	/**
	 * 根据资源ID获取资源
	 * 
	 * @param resourceId
	 * @return
	 */
	ResourceVo getResource(String resourceId);

	/**
	 * 查询推荐资源
	 * @param map
	 * @return
	 */
	List<ResourceVo> getRecommendResourceList(Map<String, String> map);
	
	/**
	 * 更新资源信息
	 * @param res
	 * @return
	 */
	int modifyResource(ResourceVo res);
	
	/**
	 * 删除资源与年级的关系
	 * @param resourceId
	 * @return
	 */
	int delResIDRClslevelID(String resourceId);
}