package com.codyy.slr.dao;

import java.util.List;

import com.codyy.slr.entity.Classlevel;

public interface ClasslevelMapper {
	int deleteByPrimaryKey(String classlevelId);

	int insert(Classlevel record);

	int insertSelective(Classlevel record);

	Classlevel selectByPrimaryKey(String classlevelId);

	int updateByPrimaryKeySelective(Classlevel record);

	int updateByPrimaryKey(Classlevel record);

	Classlevel getClasslevelByName(String classleveName);

	List<Classlevel> getClasslevelList(String classlevelName);

	void modifyClasslevelSort(List<Classlevel> list);

}
