/*
 *   阔地教育科技有限公司版权所有（codyy.com/codyy.cn）
 *   Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */
package com.codyy.slr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.service.WRService;

/**  
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author huangshengda  
 * @date 2018年1月17日   
 * @version  1.0
*/
@Controller
public class TestController {

	@Autowired
	private WRService wRService;

	@RequestMapping("wrtest")
	@ResponseBody
	public String test() {
		wRService.test();
		return "success";
	}
}
