package com.codyy.slr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.service.ResourceService;
import com.codyy.slr.vo.HomeLiveVo;
import com.codyy.slr.vo.ResourceVo;
import com.codyy.slr.vo.ReturnVoOne;

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
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private ResourceService resourceService;

	/**
	 * 获取所有直播课程信息
	 * 
	 * @return
	 */
	@RequestMapping("getHomeLiveList")
	@ResponseBody
	public ReturnVoOne<List<HomeLiveVo>> getHomeLiveList() {

		ReturnVoOne<List<HomeLiveVo>> result = new ReturnVoOne<List<HomeLiveVo>>();
		List<HomeLiveVo> list = resourceService.getHomeLiveList();

		if (list != null) {
			result.setData(list);
		} else {
			result.setCode(Constants.FAILED);
			result.setMsg("查询失败!");
		}

		return result;
	}

	/**
	 * 获取最新上传的8节课程(按上传时间降序排序)
	 * 
	 * @return
	 */
	@RequestMapping("getHomeResourceList")
	@ResponseBody
	public ReturnVoOne<List<ResourceVo>> getHomeResourceList() {

		ReturnVoOne<List<ResourceVo>> result = new ReturnVoOne<List<ResourceVo>>();
		List<ResourceVo> list = resourceService.getHomeResourceList();

		if (list != null) {
			result.setData(list);
		} else {
			result.setCode(Constants.FAILED);
			result.setMsg("查询失败!");
		}

		return result;
	}

}
