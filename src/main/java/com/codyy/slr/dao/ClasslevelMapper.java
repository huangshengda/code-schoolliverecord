package com.codyy.slr.dao;

import com.codyy.slr.entity.Classlevel;

public interface ClasslevelMapper {
    int deleteByPrimaryKey(String classlevelId);

    int insert(Classlevel record);

    int insertSelective(Classlevel record);

    Classlevel selectByPrimaryKey(String classlevelId);

    int updateByPrimaryKeySelective(Classlevel record);

    int updateByPrimaryKey(Classlevel record);
}