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

import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.Classlevel;
import com.codyy.slr.service.ClasslevelService;
import com.codyy.slr.util.StringUtils;
import com.codyy.slr.vo.ReturnVoList;
import com.codyy.slr.vo.ReturnVoOne;

/**
 * 
 * @Description: 年级
 * @author bingshaowen 
 * @date 2016年12月6日   
 *
 */
@Controller
@RequestMapping("base/classlevel")
public class ClasslevelController {
	@Autowired
	ClasslevelService classlevelService;

	/**
	 * 
	 * @Description: 获取年级列表
	 * @param classlevelName
	 * @return
	 *
	 */
	@RequestMapping("list")
	@ResponseBody
	public ReturnVoList<Classlevel> getClasslevelList(String classlevelName) {
		int code = 1;
		String msg = "操作成功";
		List<Classlevel> classlevelList = new ArrayList<Classlevel>();
		try {
			classlevelList = classlevelService.getClasslevelList(classlevelName);
		} catch (Exception e) {
			code = Constants.FAILED;
			msg = "操作失败";
			e.printStackTrace();
		}
		return new ReturnVoList<Classlevel>(code, msg, classlevelList);
	}

	/**
	 * 
	 * @Description: 新增年级
	 * @param classlevel
	 * @return
	 *
	 */
	@RequestMapping("add")
	@ResponseBody
	public ReturnVoOne<Classlevel> addClasslevel(Classlevel classlevel) {
		int code;
		String msg;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = classlevelService.addClasslevel(classlevel);
			code = Integer.parseInt(String.valueOf(map.get("code")));
			msg = String.valueOf(map.get("msg"));
		} catch (Exception e) {
			code = Constants.FAILED;
			msg = "操作失败";
			e.printStackTrace();
		}
		return new ReturnVoOne<Classlevel>(code, msg);
	}

	/**
	 * 
	 * @Description: 删除年级
	 * @param classlevel
	 * @return
	 *
	 */
	@RequestMapping("delete")
	@ResponseBody
	public ReturnVoOne<Classlevel> delClasslevel(Classlevel classlevel) {
		int code = Constants.SUCCESS;
		String msg = "删除成功";
		classlevel.setDeleteFlag("Y");
		classlevel.setDeleteTime(new Date());
		if (classlevelService.modifyClasslevel(classlevel) != 1) {
			msg = "删除失败";
			code = Constants.FAILED;
		}
		;
		return new ReturnVoOne<Classlevel>(code, msg);
	}

	/**
	 * 
	 * @Description: 修改年级名称
	 * @param classlevel
	 * @return
	 *
	 */
	@RequestMapping("update")
	@ResponseBody
	public ReturnVoOne<Classlevel> modifyClasslevelName(Classlevel classlevel) {
		int code = Constants.SUCCESS;
		String msg = "编辑成功";
		try {
			List<Classlevel> list = classlevelService.getClasslevelList(classlevel.getClasslevelName());
			if (list.size() == 0) {
				if (classlevelService.modifyClasslevel(classlevel) != 1) {
					msg = "编辑失败";
					code = Constants.FAILED;
				}
				;
			} else {
				msg = "学科名称重复";
				code = Constants.FAILED;
			}
		} catch (Exception e) {
			code = Constants.FAILED;
			msg = "操作失败";
			e.printStackTrace();
		}
		return new ReturnVoOne<Classlevel>(code, msg);
	}

	/**
	 * 
	 * @Description: 修改年级排序
	 * @param classlevelIds
	 * @return
	 *
	 */
	@RequestMapping("sort")
	@ResponseBody
	public ReturnVoOne<Classlevel> modifyClasslevelSort(String classlevelIds) {
		int code = 1;
		String msg = "排序成功";
		if(!StringUtils.isNotBlank(classlevelIds)){
			return new ReturnVoOne<Classlevel>(0, "年级Id为空");
		}
		String id[] = classlevelIds.split(",");
		List<Classlevel> list = new ArrayList<Classlevel>();
		for (int i = 0; i < id.length; i++) {
			Classlevel sub = new Classlevel();
			sub.setClasslevelId(id[i]);
			sub.setSort(i + 1);
			list.add(sub);
		}
		try {
			classlevelService.modifyClasslevelSort(list);
		} catch (Exception e) {
			code = Constants.FAILED;
			msg = "排序失败";
			e.printStackTrace();
		}
		return new ReturnVoOne<Classlevel>(code, msg);
	}
}
