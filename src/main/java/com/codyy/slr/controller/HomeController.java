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
 * 
 * @Description: 首页资源信息查询
 * @author huangshengda  
 * @date 2016年12月17日   
 *
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
		try {
			List<HomeLiveVo> list = resourceService.getHomeLiveList();
			result = new ReturnVoList<HomeLiveVo>(Constants.SUCCESS, "操作成功", list);
		} catch (Exception e) {
			result = new ReturnVoList<HomeLiveVo>(Constants.FAILED, "查询失败", null);
			e.printStackTrace();
		}

		return result;
	}
}
