package com.codyy.slr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codyy.slr.vo.ReturnVoOne;

/**
 * 网站基本配置 
 * @author huangshengda
 *
 */

@Controller
@RequestMapping("base")
public class BasicInfoController {

	@RequestMapping("modifyBasicInfo")
	public ReturnVoOne modifyBasicInfo(){
		
		return null;
	}
}
