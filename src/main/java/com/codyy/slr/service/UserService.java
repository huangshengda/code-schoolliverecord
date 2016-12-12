package com.codyy.slr.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.dao.UserMapper;
import com.codyy.slr.entity.User;
import com.codyy.slr.util.SecurityUtils;
import com.codyy.slr.util.UUIDUtils;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	/**
	 * 
	 * @Description: 获取deleteFlag为N的用户,
	 * 				根据不同登陆者类型返回不同操作项
	 * @param page
	 * @return
	 *
	 */
	public Page getUserList(Page page) {
		User userLogin;
		List<User> userList = userMapper.getUserListPageList(page);
		if ((User) page.getMap().get("user") != null) {
			userLogin = (User) page.getMap().get("user");
			for (User user : userList) {
				if (Constants.SUPER_ADMIN.equals(userLogin.getUserType())) {
					if (Constants.SUPER_ADMIN.equals(user.getUserType())) {
						user.setOpt(Constants.EDIT);
					}
				} else {
					if (user.getUserType().contains(Constants.ADMIN)) {
						if (userLogin.getUserId().equals(user.getUserId())) {
							user.setOpt(Constants.EDIT);
						} else {
							user.setOpt(null);
						}
					}
				}
				if (Constants.SUPER_ADMIN.equals(user.getUserType())) {
					user.setUserType_chinese(Constants.SUPER_ADMIN_Chinese);
				} else if (Constants.ADMIN.equals(user.getUserType())) {
					user.setUserType_chinese(Constants.ADMIN_Chinese);
				} else if (Constants.TEACHER.equals(user.getUserType())) {
					user.setUserType_chinese(Constants.TEACHER_Chinese);
				} else {
					user.setUserType_chinese(Constants.STUDENT_Chinese);
				}
			}
		}
		page.setData(userList);
		return page;
	}

	/**
	 * 
	 * @Description: 新增
	 * @param user
	 * @return
	 *
	 */
	public int addUser(User user) {
		user.setDeleteFlag("N");
		user.setPassword(SecurityUtils.MD5String(user.getPassword()));
		user.setUserId(UUIDUtils.getUUID());
		user.setCreateTime(new Date());
		return userMapper.insertSelective(user);
	}

	/**
	 * 
	 * @Description: 逻辑删除
	 * @param userId
	 * @return
	 *
	 */
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

	public User selectByPrimaryKey(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	public User getUserByUserNameAndPw(Map<String, Object> map) {
		return userMapper.getUserByNameAndPw(map);
	}

}
