package com.codyy.slr.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.dao.ClasslevelMapper;
import com.codyy.slr.entity.Classlevel;
import com.codyy.slr.util.UUIDUtils;

/**
 * 
 * @Description: 年级Service  
 * @author huangshengda  
 * @date 2016年12月6日   
 *
 */
@Service
public class ClasslevelService {

	@Autowired
	private ClasslevelMapper classlevelMapper;

	public List<Classlevel> getClasslevelList(String ClasslevelName) {
		return classlevelMapper.getClasslevelList(ClasslevelName);
	}

	/**
	 * 
	 * @Description:添加年级  
	 * @param Classlevel
	 * @return
	 *
	 */
	public Map<String, Object> addClasslevel(Classlevel Classlevel) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = 0;
		int code = Constants.SUCCESS;
		String msg = "添加成功";
		List<Classlevel> list = classlevelMapper.getClasslevelList(null);
		for (Classlevel s : list) {
			if (Classlevel.getClasslevelName().equals(s.getClasslevelName())) {
				count++;
			}
		}
		if (count == 0) {
			Classlevel.setSort(list.size() + 1);
			Classlevel.setCreateTime(new Date());
			Classlevel.setDeleteFlag("N");
			Classlevel.setClasslevelId(UUIDUtils.getUUID());
			if (classlevelMapper.insertSelective(Classlevel) != 1) {
				msg = "添加失败";
				code = Constants.FAILED;
			}
			;
		} else {
			msg = "学科名称重复";
			code = Constants.FAILED;
		}
		map.put("code", code);
		map.put("msg", msg);
		return map;
	}

	/**
	 * 
	 * @Description: 修改年级 
	 * @param Classlevel
	 * @return
	 *
	 */
	public int modifyClasslevel(Classlevel Classlevel) {
		return classlevelMapper.updateByPrimaryKeySelective(Classlevel);
	}

	/**
	 * 
	 * @Description: 修改排序 
	 * @param list
	 *
	 */
	public void modifyClasslevelSort(List<Classlevel> list) {
		classlevelMapper.modifyClasslevelSort(list);
	}

}
