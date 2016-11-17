package com.codyy.slr.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.dao.UserMapper;
import com.codyy.slr.entity.User;
import com.codyy.slr.util.SecurityUtils;
import com.codyy.slr.util.StringUtils;
import com.codyy.slr.util.UUIDUtils;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public Page getUserList(Page page) {
		User userLogin = new User();
		String userLoginId = page.getMap().get("userId").toString();
		List<User> userList = userMapper.getUserListPageList(page);
		if(StringUtils.isNotBlank(userLoginId)){
			userLogin =  userMapper.selectByPrimaryKey(userLoginId);
			for(User user:userList){
				if("SUPER_ADMIN".equals(userLogin.getUserType())){
					if("SUPER_ADMIN".equals(user.getUserType())){
						user.setOpt(Constants.EDIT);
					}
				}else{
					if(user.getUserType().contains("ADMIN")){
						if(userLogin.getUserId().equals(user.getUserId())){
							user.setOpt(Constants.EDIT);
						}else{
							user.setOpt(null);
						}
					}
				}
			}
		}
		page.setData(userList);
		return page;
	}

	public int addUser(User user) {
		user.setPassword(SecurityUtils.MD5String(user.getPassword()));
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
