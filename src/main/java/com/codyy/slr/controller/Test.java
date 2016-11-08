package com.codyy.slr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.service.TestService;

/**
 * 
 * @author huangshengda
 *
 */

@Controller
@RequestMapping("/test1")
public class Test {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("gethtml")
	public String testName() throws Exception {
		return "index";
	}
	
	@RequestMapping("getMsg")
	@ResponseBody
	public String getMsg() {
		return "hello codyy!";
	}
	
	@RequestMapping("getNames")
	@ResponseBody
	public String getNames() {
		return testService.getNames().get(0);
	}
	
	
}
