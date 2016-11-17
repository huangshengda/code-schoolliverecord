package com.codyy.slr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.service.ResourceService;
import com.codyy.slr.vo.HomeLiveVo;
import com.codyy.slr.vo.ReturnVoList;

/**
 * File Description      : 首页资源信息查询
 * Author                : GuangY
 * Create Date           : 2016/11/09
 * Reviewed By           :
 * Reviewed Date         :
 * Modified By           :
 * Modified Date         :
 * Comments              :
 * CopyRight             : COPYRIGHT(c) www.codyy.com   All Rights Reserved(2016)
 * *******************************************************************************************
 */

@Controller
@RequestMapping("/home/live")
public class HomeController {

	@Autowired
	private ResourceService resourceService;

	/**
	 * 获取所有直播课程信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public ReturnVoList<HomeLiveVo> getHomeLiveList() {

		ReturnVoList<HomeLiveVo> result = null;
		try{
			List<HomeLiveVo> list = resourceService.getHomeLiveList();
			result = new ReturnVoList<HomeLiveVo>(Constants.SUCCESS, "操作成功", list);
		}catch(Exception e){
			result = new ReturnVoList<HomeLiveVo>(Constants.FAILED, "查询失败", null);
			e.printStackTrace();
		}
		
		return result;
	}
}
