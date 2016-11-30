package com.codyy.slr.dao;

import java.util.List;

import com.codyy.slr.entity.DmsServer;
import com.codyy.slr.vo.DmsServerVo;

public interface DmsServerMapper {
    int deleteByPrimaryKey(String serverId);

    int insert(DmsServer record);

    int insertSelective(DmsServer record);

    DmsServer selectByPrimaryKey(String serverId);

    int updateByPrimaryKeySelective(DmsServer record);

    int updateByPrimaryKey(DmsServer record);
    
    List<DmsServerVo> getDmsServerList(String serverName);
    
}
