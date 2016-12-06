package com.codyy.slr.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.dao.DemandResMapper;
import com.codyy.slr.util.HostConfigUtils;
import com.codyy.slr.vo.ResourceVo;

/**
 * 
 * @Description: 资源点播Service  
 * @author huangshengda  
 * @date 2016年12月6日   
 *
 */
@Service
public class DemandResService {

	@Autowired
	private DemandResMapper demandResMapper;

	/**
	 * 
	 * @Description: 获取获取点播资源  
	 * @param req
	 * @param page
	 * @return
	 *
	 */
	public Page getDemandResPageList(HttpServletRequest req, Page page) {
		String contextpath = HostConfigUtils.getHost(req) + "/download/img/" + Constants.IMG_REAL;
		List<ResourceVo> list = demandResMapper.getDemandResPageList(page);
		for (ResourceVo resVo : list) {
			resVo.setThumbPath(contextpath + resVo.getThumbPath());
		}
		page.setData(list);
		return page;
	}
}
