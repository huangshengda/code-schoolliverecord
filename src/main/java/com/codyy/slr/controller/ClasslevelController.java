package com.codyy.slr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.entity.Classlevel;
import com.codyy.slr.vo.ReturnVoOne;

/**
 * 年级
 * @author huangshengda
 *
 */
@Controller
@RequestMapping("classlevel")
public class ClasslevelController {

	/**
	 * 获取年级
	 * @return
	 */
	@RequestMapping("getClasslevelList")
	@ResponseBody
	public ReturnVoOne<Classlevel> getClasslevelList(){
		return null;
	}
	
	/**
	 * 增加年级
	 * @return
	 */
	@RequestMapping("addClasslevel")
	@ResponseBody
	public ReturnVoOne addClasslevel(String classlevelName){
		//1.判断年级名称是否存在
		//2.添加到数据库
		//3.返回是否添加成功信息
		return null;
	}
	
	/**
	 * 删除年级
	 * @return
	 */
	@RequestMapping("delClasslevel")
	@ResponseBody
	public ReturnVoOne delClasslevel(String classlevelId){
		return null;
	}
	
	/**
	 * 修改年级名称
	 * @return
	 */
	@RequestMapping("modifyClasslevelName")
	@ResponseBody
	public ReturnVoOne modifyClasslevelName(String classlevelId,String classlevelName){
		return null;
	}
	
	/**
	 * 修改年级排序
	 * @return
	 */
	@RequestMapping("modifyClasslevelSort")
	@ResponseBody
	public ReturnVoOne modifyClasslevelSort(String classlevelIds){
		return null;
	}
}
