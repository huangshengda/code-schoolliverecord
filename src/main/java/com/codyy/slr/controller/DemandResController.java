package com.codyy.slr.controller;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.parambean.SearchResourceParam;
import com.codyy.slr.service.DemandResService;
import com.codyy.slr.util.MySqlKeyWordUtils;
import com.codyy.slr.util.ParamUtil;
import com.codyy.slr.vo.ResourceVo;
import com.codyy.slr.vo.ReturnVoList;

/**
 * File Description      : 点播资源
 * Author                : GuangY
 * Create Date           : 2016/11/15
 * Reviewed By           :
 * Reviewed Date         :
 * Modified By           :
 * Modified Date         :
 * Comments              :
 * CopyRight             : COPYRIGHT(c) www.codyy.com   All Rights Reserved(2016)
 * *******************************************************************************************
 */

@Controller
@RequestMapping("/demand")
public class DemandResController {

	@Autowired
	private DemandResService demandResService;

	/**
	 * 获取点播资源信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list",method = RequestMethod.POST )
	@ResponseBody
	public ReturnVoList<ResourceVo> getDemandResPageList(Page page,
			SearchResourceParam param) {
		
		ReturnVoList<ResourceVo> result = null;
		
		if (StringUtils.isNotBlank(param.getResourceNameKey())) {
			param.setResourceNameKey(MySqlKeyWordUtils.MySqlKeyWordReplace(param.getResourceNameKey()));
		}
		
		try{
			Map<String, Object> paramMap = ParamUtil.bean2Map(param);
			page.setMap(paramMap);

			page = demandResService.getDemandResPageList(page);

			result = new ReturnVoList<ResourceVo>(page);
		}catch(Exception e){
			result = new ReturnVoList<ResourceVo>(Constants.FAILED,"查询失败",null);
			e.printStackTrace();
		}

		return result;
	}
}
