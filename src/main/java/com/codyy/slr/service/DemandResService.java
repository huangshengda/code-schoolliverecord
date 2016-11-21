package com.codyy.slr.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	public Page getDemandResPageList(HttpServletRequest req, Page page) {
		String contextpath = req.getScheme() +"://" + req.getServerName()  + ":" +req.getServerPort() 
				+req.getContextPath()+"/download/img/";
		List<ResourceVo> list = demandResMapper.getDemandResPageList(page);
		for(ResourceVo resVo : list){
			String thumbPath = resVo.getThumbPath();
			resVo.setThumbPath(contextpath + thumbPath);
		}
		page.setData(list);
		return page;
	}
}
