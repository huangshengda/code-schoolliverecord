package com.codyy.slr.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.common.testUI.annotation.ApiParam;
import com.codyy.slr.parambean.TestBean;
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
	public String getMsg(String name,String password) {
		return "hello codyy!";
	}
	
	/**
	 * 
	 * @param name 
	 * @param password
	 * @param remember
	 * @return
	 */
	
	@RequestMapping("getNames")
	@ResponseBody
	public Map<String,String> getNames(TestBean test,
			@ApiParam("√‹¬Î") String password,
			
			int remember) {
		 testService.getNames();
		 Map<String,String> map = new HashMap<String,String>();
		 map.put("name", "lizhiwei");
		return map;
	}
	
	
}
