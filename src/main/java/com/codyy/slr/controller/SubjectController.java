package com.codyy.slr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.entity.Subject;
import com.codyy.slr.vo.ReturnVoOne;

/**
 * 年级
 * @author huangshengda
 *
 */
@Controller
@RequestMapping("subject")
public class SubjectController {

	/**
	 * 获取年级
	 * @return
	 */
	@RequestMapping("getSubjectList")
	@ResponseBody
	public ReturnVoOne<Subject> getSubjectList(){
		return null;
	}
	
	/**
	 * 增加年级
	 * @return
	 */
	@RequestMapping("addSubject")
	@ResponseBody
	public ReturnVoOne addSubject(String subjectName){
		//1.判断年级名称是否存在
		//2.添加到数据库
		//3.返回是否添加成功信息
		return null;
	}
	
	/**
	 * 删除年级
	 * @return
	 */
	@RequestMapping("delSubject")
	@ResponseBody
	public ReturnVoOne delSubject(String subjectId){
		return null;
	}
	
	/**
	 * 修改年级名称
	 * @return
	 */
	@RequestMapping("modifySubjectName")
	@ResponseBody
	public ReturnVoOne modifySubjectName(String subjectId,String subjectName){
		return null;
	}
	
	/**
	 * 修改年级排序
	 * @return
	 */
	@RequestMapping("modifySubjectSort")
	@ResponseBody
	public ReturnVoOne modifySubjectSort(String subjectIds){
		return null;
	}
}
