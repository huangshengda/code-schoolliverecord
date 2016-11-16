package com.codyy.slr.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.entity.Subject;
import com.codyy.slr.service.SubjectService;
import com.codyy.slr.vo.ReturnVoList;
import com.codyy.slr.vo.ReturnVoOne;

/**
 * 学科
 * @author huangshengda
 *
 */
@Controller
@RequestMapping("subject")
public class SubjectController {
	
	@Autowired
	SubjectService subjectService;
	/**
	 * 获取学科
	 * @return
	 */
	@RequestMapping("getSubjectList")
	@ResponseBody
	public ReturnVoList<Subject> getSubjectList(String subjectName){
		int code = 1;
		String msg = "操作成功";
		List<Subject> subjectList = new ArrayList<Subject>();
		try {
			subjectList = subjectService.getSubjectList(subjectName);
		} catch (Exception e) {
			 code = 0;
			 msg = "操作失败";
			e.printStackTrace();
		}
		return new ReturnVoList<Subject>(code,msg,subjectList);
	}
	
	/**
	 * 增加学科
	 * @return
	 */
	@RequestMapping("addSubject")
	@ResponseBody
	public ReturnVoOne<Subject> addSubject(Subject subject){
		int code ;
		String msg ;
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			map = subjectService.addSubject(subject);
			code = Integer.parseInt(String.valueOf(map.get("code")));
			msg = String.valueOf(map.get("msg"));
		} catch (Exception e) {
			 code = 0;
			 msg = "操作失败";
			e.printStackTrace();
		}
		return new ReturnVoOne<Subject>(code,msg);
	}
	
	/**
	 * 删除学科
	 * @return
	 */
	@RequestMapping("delSubject")
	@ResponseBody
	public ReturnVoOne<Subject> delSubject(Subject subject){
		int code = 1;
		String msg = "删除成功";
		subject.setDeleteFlag("Y");
		subject.setDeleteTime(new Date());
		if(subjectService.modifySubject(subject)!=1){
			msg = "删除失败";
			code = 0;
		};
		return new ReturnVoOne<Subject>(code,msg);
	}
	
	/**
	 * 修改学科名称
	 * @return
	 */
	@RequestMapping("modifySubjectName")
	@ResponseBody
	public ReturnVoOne<Subject> modifySubject(Subject subject){
		int code = 1;
		String msg = "编辑成功";
		try {
			List<Subject> list = subjectService.getSubjectList(subject.getSubjectName());
			if(list.size()==0){
				if(subjectService.modifySubject(subject)!=1){
					msg = "编辑失败";
					code = 0;
				};
			}else{
				msg = "学科名称重复";
				code = 0;
			}
		} catch (Exception e) {
			 code = 0;
			 msg = "操作失败";
			e.printStackTrace();
		}
		return new ReturnVoOne<Subject>(code,msg);
	}
	
	/**
	 * 修改学科排序
	 * @return
	 */
	@RequestMapping("modifySubjectSort")
	@ResponseBody
	public ReturnVoOne<Subject> modifySubjectSort(String subjectIds){
		int code = 1;
		String msg = "排序成功";
		String id[] = subjectIds.split(",");
		List<Subject> list = new ArrayList<Subject>();
		for(int i=0;i<id.length;i++){
			Subject sub = new Subject();
			sub.setSubjectId(id[i]);
			sub.setSort(i+1);
			list.add(sub);
		}
		try {
			subjectService.modifySubjectSort(list);
		} catch (Exception e) {
			 code = 0;
			 msg = "排序失败";
			e.printStackTrace();
		}
		return new ReturnVoOne<Subject>(code,msg);
	}
}