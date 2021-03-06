package com.codyy.slr.dao;

import java.util.List;
import java.util.Map;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.entity.User;
import com.codyy.slr.vo.UserExportModel;

public interface UserMapper {
	int deleteByPrimaryKey(String userId);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(String userId);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	List<User> getUserListPageList(Page page);

	User getUserByUserName(Map<String, Object> map);

	List<User> getUserByNameAndPw(Map<String, Object> map);

	void insertUsers(List<Object> list);

	List<UserExportModel> getUserExportList(Map<String, Object> map);

}
