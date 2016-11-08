package com.codyy.slr.dao;

import com.codyy.slr.entity.ResComment;

public interface ResCommentMapper {
    int deleteByPrimaryKey(String resourceCommentId);

    int insert(ResComment record);

    int insertSelective(ResComment record);

    ResComment selectByPrimaryKey(String resourceCommentId);

    int updateByPrimaryKeySelective(ResComment record);

    int updateByPrimaryKey(ResComment record);
}