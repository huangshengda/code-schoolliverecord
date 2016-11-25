package com.codyy.slr.dao;

import com.codyy.slr.entity.DmsServer;

public interface DmsServerMapper {
    int deleteByPrimaryKey(String serverId);

    int insert(DmsServer record);

    int insertSelective(DmsServer record);

    DmsServer selectByPrimaryKey(String serverId);

    int updateByPrimaryKeySelective(DmsServer record);

    int updateByPrimaryKey(DmsServer record);
}