package com.codyy.slr.dao;

import com.codyy.slr.entity.BasicInfoKey;

public interface BasicInfoKeyMapper {
    int deleteByPrimaryKey(String keyId);

    int insert(BasicInfoKey record);

    int insertSelective(BasicInfoKey record);

    BasicInfoKey selectByPrimaryKey(String keyId);

    int updateByPrimaryKeySelective(BasicInfoKey record);

    int updateByPrimaryKey(BasicInfoKey record);
}