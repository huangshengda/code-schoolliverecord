package com.codyy.slr.dao;
import java.util.List;

import com.codyy.slr.entity.Resource;
import com.codyy.slr.vo.HomeLiveVo;
import com.codyy.slr.vo.ResourceVo;

public interface ResourceMapper {
	//获取所有直播课程信息
	List<HomeLiveVo> getHomeLiveList();
		
	//获取最新上传的8节课程(按上传时间降序排序)
	List<ResourceVo> getHomeResourceList();
	
    int deleteByPrimaryKey(String resourceId);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(String resourceId);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
}