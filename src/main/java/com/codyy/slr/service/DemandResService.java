package com.codyy.slr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.dao.DemandResMapper;
import com.codyy.slr.vo.ResourceVo;

@Service
public class DemandResService {

	@Autowired
	private DemandResMapper demandResMapper;

	// 获取获取点播资源
	public Page getDemandResPageList(Page page) {
		List<ResourceVo> list = demandResMapper.getDemandResPageList(page);
		page.setData(list);
		return page;
	}
}
