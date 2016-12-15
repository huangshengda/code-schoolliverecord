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
	public ReturnVoOne<BasicInfoVo> modifyBasicInfo(BasicInfoVo param) {
		ReturnVoOne<BasicInfoVo> returnVoOne = new ReturnVoOne<BasicInfoVo>();
		try {
			boolean flag = basicInfoService.updateBasicInfo(param);
			if (flag) {
				BasicInfoVo res = new BasicInfoVo();
				List<BasicInfo> list = basicInfoService.getBasicInfo();
				for (BasicInfo info : list) {
					if ("title".equalsIgnoreCase(info.getInfoName())) {
						res.setTitle(info.getInfoValue());
					} else if ("logoPath".equalsIgnoreCase(info.getInfoName())) {
						res.setLogoPath(Constants.ROOT_SERVER + "/download/img" + Constants.PATH_SEPARATOR + Constants.IMG_REAL + info.getInfoValue());
					} else {
						res.setButtomMsg(info.getInfoValue());
					}
				}
				returnVoOne.setData(res);

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
			BasicInfoVo param = new BasicInfoVo();
			List<BasicInfo> list = basicInfoService.getBasicInfo();
			for (BasicInfo info : list) {
				if ("title".equalsIgnoreCase(info.getInfoName())) {
					param.setTitle(info.getInfoValue());
				} else if ("logoPath".equalsIgnoreCase(info.getInfoName())) {
					param.setLogoPath(info.getInfoValue());
				} else {
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
