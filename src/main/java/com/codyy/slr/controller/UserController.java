package com.codyy.slr.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.User;
import com.codyy.slr.service.UserService;
import com.codyy.slr.util.MySqlKeyWordUtils;
import com.codyy.slr.util.TokenUtils;
import com.codyy.slr.util.UUIDUtils;
import com.codyy.slr.vo.ReturnVoList;
import com.codyy.slr.vo.ReturnVoOne;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	final String PasswordRegex = "^[0-9a-zA-Z|,|.|;|~|!|@|@|#|$|%|\\^|&|*|(|)|_|+|-|=|\\|/|<|>]{6,18}$";
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping("login")
	public  ReturnVoOne<User> login(Page page,User user){
		Map<String,Object> map = new HashMap<String, Object>();
		int code = Constants.SUCCESS;
		String msg = "登陆成功";
		map.put("username", MySqlKeyWordUtils.MySqlKeyWordReplace(user.getUsername()));
		map.put("password",user.getPassword());
		List<User> userList = new ArrayList<User>();
		page.setPaging(false);
		page.setMap(map);
		try {
			userList = (List<User>) userService.getUserList(page).getData();
			if(userList.size()==1){
				user = userList.get(0);
				user.setToken(UUIDUtils.getUUID());
				TokenUtils.putUserIdToCache(user.getToken(),user);
			}else{
				code = Constants.FAILED;
				msg = "用户名或密码错误";
			}
		} catch (Exception e) {
			code = Constants.FAILED;
			 msg = "登陆失败";
			e.printStackTrace();
		}
		return new ReturnVoOne<User>(code,msg,user);
	}

	/**
	 * 查询
	 * @param page
	 * @param user
	 * @return
	 * @throws ExecutionException 
	 */
	@ResponseBody
	@RequestMapping("/base/user/list")
	public ReturnVoList<User> getUserList(HttpServletRequest req,Page page,User user) throws ExecutionException{
		int code = Constants.SUCCESS;
		String msg = "查询成功";
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("username", MySqlKeyWordUtils.MySqlKeyWordReplace(user.getUsername()));
		map.put("realname", MySqlKeyWordUtils.MySqlKeyWordReplace(user.getRealname()));
		map.put("userType",user.getUserType());
		map.put("user", req.getAttribute("user"));
		page.setMap(map);
		user = (User) req.getAttribute("user");
		try {
			page = userService.getUserList(page);
		} catch (Exception e) {
			code = Constants.FAILED;
			 msg = "查询失败";
			e.printStackTrace();
		}
		return new ReturnVoList<User>(page,code,msg);
	}
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/base/user/add")
	public ReturnVoOne<User> addUser(User user){
		Page page = new Page();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("username", user.getRealname());
		page.setMap(map);
		page.setPaging(false);
		int count = 0;
		String password = "666666";
		user.setPassword(user.getPassword()==null?password:user.getPassword());
		if((user.getUsername().matches(PasswordRegex))
				&&(user.getPassword().matches(PasswordRegex))
				&&(user.getRealname().length()>0)
				&&(user.getRealname().length()<11)){
			if(userService.getUserList(page).getTotalDatas()==0){
				try {
					count = userService.addUser(user);
				} catch (Exception e) {
					e.printStackTrace();
					return new ReturnVoOne<User>(Constants.FAILED,"操作失败");
				}
			}else{
				return new ReturnVoOne<User>(Constants.FAILED,"用户名重复");
			}
			if(count==1){
				return new ReturnVoOne<User>();
			}else{
				return new ReturnVoOne<User>(Constants.FAILED,"添加失败");
			}
		}else{
			return new ReturnVoOne<User>(Constants.FAILED,"用户名、姓名或密码格式不正确");
		}
	}
	
	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("base/user/del")
	public ReturnVoOne<User> delUser(String userId){
		int count = 0;
		try {
			count = userService.deleteByPrimaryKey(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return new ReturnVoOne<User>(Constants.FAILED,"操作失败");
		}
			
		if(count==1){
			return new ReturnVoOne<User>();
		}else{
			return new ReturnVoOne<User>(Constants.FAILED,"操作失败");
		}
	}
	
	/**
	 * 编辑用户
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/base/user/update")
	public ReturnVoOne<User> editUser(User user){
		Page page = new Page();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("username", user.getRealname());
		page.setMap(map);
		
		page.setPaging(false);
		int code = Constants.SUCCESS;
		String msg = "操作成功";
		if((user.getRealname().length()>0)&&(user.getRealname().length()<11)){
			
			if(user.getPassword()!=null){
				if(!user.getPassword().matches(PasswordRegex)){
					return new ReturnVoOne<User>(Constants.FAILED,"密码格式不正确");
				}
			}
			
			if(userService.getUserList(page).getTotalDatas()==1){
				try {
					userService.editUser(user);
				} catch (Exception e) {
					e.printStackTrace();
					code=Constants.FAILED;
					msg = "操作失败";
				}
			}
			return new ReturnVoOne<User>(code,msg);
		}else{
			return new ReturnVoOne<User>(Constants.FAILED,"用户名格式不正确");
		}
	}
	
}
