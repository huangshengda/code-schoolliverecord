package com.codyy.slr.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.dao.UserMapper;
import com.codyy.slr.entity.User;
import com.codyy.slr.util.SecurityUtil;
import com.codyy.slr.util.UUIDUtils;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public Page getUserList(Page page) {
		List<User> userList = userMapper.getUserListPageList(page);
		page.setData(userList);
		return page;
	}

	public int addUser(User user) {
		user.setPassword(SecurityUtil.MD5String(user.getPassword()));
		user.setUserId(UUIDUtils.getUUID());
		user.setCreateTime(new Date());
		return userMapper.insertSelective(user);
		
	}

	public int deleteByPrimaryKey(String userId) {
		User user = new User();
		user.setUserId(userId);
		user.setDeleteFlag("Y");
		user.setDeleteTime(new Date());
		return userMapper.updateByPrimaryKeySelective(user);
	}

	public int editUser(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
		
	}

}
