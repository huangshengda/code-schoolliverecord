package com.codyy.slr.dao;

import java.util.List;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.vo.ResourceVo;

public interface DemandResMapper {

	// 获取点播资源
	List<ResourceVo> getDemandResPageList(Page page);
}