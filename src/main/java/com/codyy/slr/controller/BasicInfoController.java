package com.codyy.slr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.BasicInfo;
import com.codyy.slr.parambean.BasicInfoParam;
import com.codyy.slr.service.BasicInfoService;
import com.codyy.slr.vo.ReturnVoOne;

/**
 * 网站基本配置 
 * @author huangshengda
 *
 */

@Controller
@RequestMapping("base")
public class BasicInfoController {

	@Autowired
	private BasicInfoService basicInfoService;
	
	@RequestMapping("modifyBasicInfo")
	@ResponseBody
	public ReturnVoOne<List<BasicInfo>> modifyBasicInfo(BasicInfoParam param){
		ReturnVoOne<List<BasicInfo>> returnVoOne = new ReturnVoOne<List<BasicInfo>>();
		try {
			boolean flag = basicInfoService.updateBasicInfo(param);
			returnVoOne.setData(basicInfoService.getBasicInfo());
			if(!flag){
				returnVoOne.setMsg("修改基础信息失败");
				returnVoOne.setCode(Constants.FAILED);
			}
		} catch (Exception e) {
			returnVoOne.setMsg("修改基础信息失败");
			returnVoOne.setCode(Constants.FAILED);
		}
		
		return returnVoOne;
	}

	@RequestMapping("getBasicInfo")
	@ResponseBody
	public ReturnVoOne<List<BasicInfo>> getBasicInfo(){
		ReturnVoOne<List<BasicInfo>> returnVoOne = new ReturnVoOne<List<BasicInfo>>();
		try {
			returnVoOne.setData(basicInfoService.getBasicInfo());
		} catch (Exception e) {
			returnVoOne.setMsg("获取基础信息失败");
			returnVoOne.setCode(Constants.FAILED);
		}
		return returnVoOne;
	}
	
	
}
