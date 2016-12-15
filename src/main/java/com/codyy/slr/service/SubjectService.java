package com.codyy.slr.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.dao.SubjectMapper;
import com.codyy.slr.entity.Subject;
import com.codyy.slr.util.UUIDUtils;

@Service
public class SubjectService {

	@Autowired
	private SubjectMapper subjectMapper;

	public List<Subject> getSubjectList(String subjectName) {
		return subjectMapper.getSubjectList(subjectName);
	}

	/**
	 * 
	 * @Description: 添加前要判断是否重复
	 * @param subject
	 * @return
	 *
	 */
	public Map<String, Object> addSubject(Subject subject) {
		Map<String, Object> map = new HashMap<String, Object>();
		int count = 0;
		int code = Constants.SUCCESS;
		String msg = "添加成功";
		List<Subject> list = subjectMapper.getSubjectList(null);
		for (Subject s : list) {
			if (subject.getSubjectName().equals(s.getSubjectName())) {
				count++;
			}
		}
		if (count == 0) {
			subject.setSort(list.size() + 1);
			subject.setCreateTime(new Date());
			subject.setDeleteFlag("N");
			subject.setSubjectId(UUIDUtils.getUUID());
			if (subjectMapper.insertSelective(subject) != 1) {
				msg = "添加失败";
				code = Constants.FAILED;
			}
		} else {
			msg = "学科名称重复";
			code = Constants.FAILED;
		}
		map.put("code", code);
		map.put("msg", msg);
		return map;
	}

	public int modifySubject(Subject subject) {
		return subjectMapper.updateByPrimaryKeySelective(subject);
	}

	public void modifySubjectSort(List<Subject> list) {
		subjectMapper.modifySubjectSort(list);
	}

	public Subject getSubjectByName(String subjectName) {
		return subjectMapper.getSubjectByName(subjectName);
	}

}
