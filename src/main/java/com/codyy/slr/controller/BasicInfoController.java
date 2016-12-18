package com.codyy.slr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.service.BasicInfoService;
import com.codyy.slr.vo.BasicInfoVo;
import com.codyy.slr.vo.ReturnVoOne;

/**
 * 
 * @Description: 网站基础信息(标题,图片,底部信息)
 * @author huangshengda  
 * @date 2016年12月6日   
 *
 */
@Controller
@RequestMapping("base")
public class BasicInfoController {

	@Autowired
	private BasicInfoService basicInfoService;

	/**
	 * 
	 * @Description: 更新基础信息  
	 * @param param
	 * @return
	 *
	 */
	@RequestMapping("basicinfo/update")
	@ResponseBody
	public ReturnVoOne<BasicInfoVo> modifyBasicInfo(BasicInfoVo param, boolean thumbFlag) {
		ReturnVoOne<BasicInfoVo> returnVoOne = new ReturnVoOne<BasicInfoVo>();
		try {
			boolean flag = basicInfoService.updateBasicInfo(param, thumbFlag);
			if (flag) {
				BasicInfoVo infoVo = basicInfoService.getBasicInfo();
				returnVoOne.setData(infoVo);
			} else {
				returnVoOne.setMsg("修改基础信息失败");
				returnVoOne.setCode(Constants.FAILED);
			}
		} catch (Exception e) {
			returnVoOne.setMsg("修改基础信息失败");
			returnVoOne.setCode(Constants.FAILED);
		}

		return returnVoOne;
	}

	/**
	 * 
	 * @Description: 查询基础信息  
	 * @return
	 *
	 */
	@RequestMapping("basicinfo/get")
	@ResponseBody
	public ReturnVoOne<BasicInfoVo> getBasicInfo() {
		ReturnVoOne<BasicInfoVo> returnVoOne = new ReturnVoOne<BasicInfoVo>();
		try {
			BasicInfoVo infoVo = basicInfoService.getBasicInfo();
			returnVoOne.setData(infoVo);
		} catch (Exception e) {
			returnVoOne.setMsg("获取基础信息失败");
			returnVoOne.setCode(Constants.FAILED);
		}
		return returnVoOne;
	}

}
