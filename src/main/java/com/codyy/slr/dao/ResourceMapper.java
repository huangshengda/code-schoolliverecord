package com.codyy.slr.dao;
import java.util.List;
import java.util.Map;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.entity.Resource;
import com.codyy.slr.vo.HomeLiveVo;
import com.codyy.slr.vo.ResourceVo;

public interface ResourceMapper {
	//获取所有直播课程信息
	List<HomeLiveVo> getHomeLiveList();
		
	//获取最新上传的8节课程(按上传时间降序排序)
	List<ResourceVo> getHomeResourceList();
	
	//获取资源信息
	List<ResourceVo> getResourcePageList(Page page);
	
    /**
     * 添加资源
     * @param record
     * @return
     */
    int addResource(Resource record);
    
    /**
     * 批量插入资源和年级关系数据
     * @param list
     * @return
     */
    int addResIdClslevelIdList(List<Map<String,String>> list);
    
    /**
     * 删除资源
     * @param resourceId
     * @return
     */
    int delResByResId(String resourceId);
}