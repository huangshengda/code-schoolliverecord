package com.codyy.slr.dao;

import com.codyy.slr.entity.BasicInfoVal;

public interface BasicInfoValMapper {
    int deleteByPrimaryKey(String valId);

    int insert(BasicInfoVal record);

    int insertSelective(BasicInfoVal record);

    BasicInfoVal selectByPrimaryKey(String valId);

    int updateByPrimaryKeySelective(BasicInfoVal record);

    int updateByPrimaryKey(BasicInfoVal record);
}