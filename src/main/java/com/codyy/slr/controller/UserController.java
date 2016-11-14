package com.codyy.slr.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.entity.User;
import com.codyy.slr.service.UserService;
import com.codyy.slr.util.MySqlKeyWordUtils;
import com.codyy.slr.vo.ReturnVoList;
import com.codyy.slr.vo.ReturnVoOne;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	final String PasswordRegex = "^[0-9a-zA-Z|,|.|;|~|!|@|@|#|$|%|\\^|&|*|(|)|_|+|-|=|\\|/|<|>]{6,18}$";
	
	/**
	 * 查询
	 * @param page
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("userList")
	public ReturnVoList<User> getUserList(Page page,User user){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("username", MySqlKeyWordUtils.MySqlKeyWordReplace(user.getUsername()));
		map.put("realname", MySqlKeyWordUtils.MySqlKeyWordReplace(user.getRealname()));
		map.put("userType", MySqlKeyWordUtils.MySqlKeyWordReplace(user.getUserType()));
		page.setMap(map);
		return new ReturnVoList<User>(userService.getUserList(page));
	}
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addUser")
	public ReturnVoOne<User> addUser(User user){
		Page page = new Page();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("username", user.getUsername());
		page.setMap(map);
		page.setPaging(false);
		int count = 0;
		if((user.getUsername().matches(PasswordRegex))
				&&(user.getPassword().matches(PasswordRegex))
				&&(user.getRealname().length()>0)
				&&(user.getRealname().length()<11)){
			if(userService.getUserList(page).getTotalDatas()==0){
				try {
					count = userService.addUser(user);
				} catch (Exception e) {
					e.printStackTrace();
					return new ReturnVoOne<User>(0,"操作失败");
				}
			}else{
				return new ReturnVoOne<User>(0,"用户名重复");
			}
			if(count==1){
				return new ReturnVoOne<User>();
			}else{
				return new ReturnVoOne<User>(0,"添加失败");
			}
		}else{
			return new ReturnVoOne<User>(0,"用户名、姓名或密码格式不正确");
		}
	}
	
	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delUser")
	public ReturnVoOne<User> delUser(String userId){
		int count = 0;
		try {
			count = userService.deleteByPrimaryKey(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return new ReturnVoOne<User>(0,"操作失败");
		}
			
		if(count==1){
			return new ReturnVoOne<User>();
		}else{
			return new ReturnVoOne<User>(0,"操作失败");
		}
	}
	
	/**
	 * 编辑用户
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("editUser")
	public ReturnVoOne<User> editUser(User user){
		Page page = new Page();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("username", user.getUsername());
		page.setMap(map);
		page.setPaging(false);
		int code = 1;
		String msg = "操作成功";
		if((user.getUsername().matches(PasswordRegex))
				&&(user.getPassword().matches(PasswordRegex))
				&&(user.getRealname().length()>0)
				&&(user.getRealname().length()<11)){
			if(userService.getUserList(page).getTotalDatas()==1){
				try {
					userService.editUser(user);
				} catch (Exception e) {
					e.printStackTrace();
					code=0;
					msg = "操作失败";
				}
			}
			return new ReturnVoOne<User>(code,msg);
		}else{
			return new ReturnVoOne<User>(0,"用户名、姓名或密码格式不正确");
		}
	}
	
}
