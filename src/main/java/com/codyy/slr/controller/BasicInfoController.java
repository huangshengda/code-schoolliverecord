package com.codyy.slr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.BasicInfo;
import com.codyy.slr.service.BasicInfoService;
import com.codyy.slr.vo.BasicInfoVo;
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
	
	@RequestMapping("basicInfo/update")
	@ResponseBody
	public ReturnVoOne<List<BasicInfo>> modifyBasicInfo(BasicInfoVo param){
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

	@RequestMapping("basicInfo/get")
	@ResponseBody
	public ReturnVoOne<BasicInfoVo> getBasicInfo(){
		ReturnVoOne<BasicInfoVo> returnVoOne = new ReturnVoOne<BasicInfoVo>();
		try {
			BasicInfoVo param = new BasicInfoVo();
			List<BasicInfo> list =  basicInfoService.getBasicInfo();
			for (BasicInfo info : list) {
				if("title".equalsIgnoreCase(info.getInfoName())){
					param.setTitle(info.getInfoValue());
				}else if("logoPath".equalsIgnoreCase(info.getInfoName())){
					param.setLogoPath(info.getInfoValue());
				}else{
					param.setButtomMsg(info.getInfoValue());
				}
			}
			returnVoOne.setData(param);
		} catch (Exception e) {
			returnVoOne.setMsg("获取基础信息失败");
			returnVoOne.setCode(Constants.FAILED);
		}
		return returnVoOne;
	}
	
	
}
