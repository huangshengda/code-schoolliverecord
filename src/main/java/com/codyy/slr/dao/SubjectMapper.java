package com.codyy.slr.dao;

import java.util.List;

import com.codyy.slr.entity.Subject;

public interface SubjectMapper {
    int deleteByPrimaryKey(String subjectId);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(String subjectId);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);

	List<Subject> getSubjectList(String subjectName);

	void modifySubjectSort(List<Subject> list);
}