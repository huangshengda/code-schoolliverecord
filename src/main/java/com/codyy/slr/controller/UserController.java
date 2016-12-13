package com.codyy.slr.controller;

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
import com.codyy.slr.util.StringUtils;
import com.codyy.slr.util.TokenUtils;
import com.codyy.slr.util.UUIDUtils;
import com.codyy.slr.vo.ReturnVoList;
import com.codyy.slr.vo.ReturnVoOne;

/**
 * 
 * @Description: 用户管理
 * @author bingshaowen 
 * @date 2016年12月6日   
 *
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	private final String usernameRegex = "^[0-9a-zA-Z|,|.|;|~|!|@|@|#|$|%|\\^|&|*|(|)|_|+|-|=|\\|/|<|>]{6,18}$";

	/**
	 * 
	 * @Description: 用户登录
	 * @param page
	 * @param user
	 * @param req
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("login")
	public ReturnVoOne<User> login(User user, HttpServletRequest req) {
		String agent = req.getHeader("User-Agent");
		Map<String, Object> map = new HashMap<String, Object>();
		int code = Constants.SUCCESS;
		String msg = "登陆成功";
		if ((StringUtils.isEmpty(user.getUsername())) || (StringUtils.isEmpty(user.getPassword()))) {
			return new ReturnVoOne<User>(0, "用户名或密码为空");
		}
		map.put("username", MySqlKeyWordUtils.MySqlKeyWordReplace(user.getUsername()));
		map.put("password", user.getPassword());
		try {
			user = userService.getUserByUserNameAndPw(map);
			if (user != null) {
				user.setToken(UUIDUtils.getUUID());
				// token+agent作为key 增加破解难度
				TokenUtils.putUserIdToCache(user.getToken() + agent, user);
				if ("TEACHER".equals(user.getUserType())) {
					user.setColumn(Constants.COLUMN_MY_COURSE);
				} else if ("STUDENT".endsWith(user.getUserType())) {
					user.setColumn(Constants.COLUMN);
				} else {
					user.setColumn(Constants.COLUMN_BASE);
				}
				user.setPassword(null);
			} else {
				code = Constants.FAILED;
				msg = "用户名或密码错误";
			}
		} catch (Exception e) {
			code = Constants.FAILED;
			msg = "登陆失败";
			e.printStackTrace();
		}
		return new ReturnVoOne<User>(code, msg, user);
	}

	/**
	 * 
	 * @Description: 登出  
	 * @param req
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("loginout")
	public ReturnVoOne<List<String>> loginout(HttpServletRequest req) {
		ReturnVoOne<List<String>> one = new ReturnVoOne<List<String>>();
		try {
			User user = (User) req.getAttribute("user");
			TokenUtils.removeUserFormCache(user.getToken());
		} catch (Exception e) {
			one.setMsg("退出失败");
			one.setCode(Constants.FAILED);
		}
		one.setData(Constants.COLUMN);
		return one;
	}

	/**
	 * 
	 * @Description: 查询
	 * @param req
	 * @param page
	 * @param user
	 * @return
	 * @throws ExecutionException
	 *
	 */
	@ResponseBody
	@RequestMapping("/base/user/list")
	public ReturnVoList<User> getUserList(HttpServletRequest req, Page page, User user) throws ExecutionException {
		int code = Constants.SUCCESS;
		String msg = "查询成功";

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", MySqlKeyWordUtils.MySqlKeyWordReplace(user.getUsername()));
		map.put("realname", MySqlKeyWordUtils.MySqlKeyWordReplace(user.getRealname()));
		/*if (user.getUserType() == "-1") {
			String aaa = "123";
		}
		String aa = (user.getUserType() == "-1" ? null : user.getUserType());*/
		map.put("userType", user.getUserType());
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
		return new ReturnVoList<User>(page, code, msg);
	}

	/**
	 * 
	 * @Description: 添加用户
	 * @param user
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("/base/user/add")
	public ReturnVoOne<User> addUser(User user) {
		Page page = new Page();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", user.getRealname());
		page.setMap(map);
		page.setPaging(false);
		int count = 0;
		if ((user.getUsername().matches(usernameRegex)) && (user.getRealname().length() > 0) && (user.getRealname().length() < 11)) {
			// 用户类型判断
			if ("ADMIN".equals(user.getUserType())) {
				user.setUserType(Constants.ADMIN);
			} else if ("TEACHER".equals(user.getUserType())) {
				user.setUserType(Constants.TEACHER);
			} else if ("STUDENT".endsWith(user.getUserType())) {
				user.setUserType(Constants.STUDENT);
			} else {
				return new ReturnVoOne<User>(Constants.FAILED, "用户类型错误");
			}
			// 重名判断
			if (userService.getUserList(page).getTotalDatas() == 0) {
				try {
					count = userService.addUser(user);
				} catch (Exception e) {
					e.printStackTrace();
					return new ReturnVoOne<User>(Constants.FAILED, "操作失败");
				}
			} else {
				return new ReturnVoOne<User>(Constants.FAILED, "用户名重复");
			}
			if (count == 1) {
				return new ReturnVoOne<User>();
			} else {
				return new ReturnVoOne<User>(Constants.FAILED, "添加失败");
			}

		} else {
			return new ReturnVoOne<User>(Constants.FAILED, "用户名或姓名格式不正确");
		}
	}

	/**
	 * 
	 * @Description:删除用户
	 * @param userId
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("base/user/delete")
	public ReturnVoOne<User> delUser(String userId) {
		int count = 0;
		try {
			count = userService.deleteByPrimaryKey(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return new ReturnVoOne<User>(Constants.FAILED, "操作失败");
		}

		if (count == 1) {
			return new ReturnVoOne<User>();
		} else {
			return new ReturnVoOne<User>(Constants.FAILED, "操作失败");
		}
	}

	/**
	 * 
	 * @Description: 编辑用户
	 * @param user
	 * @param prePassword
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("/base/user/update")
	public ReturnVoOne<User> editUser(User user, String prePassword) {

		int code = Constants.SUCCESS;
		String msg = "操作成功";
		if (StringUtils.isNotEmpty(prePassword)) {// 修改密码
			user = userService.selectByPrimaryKey(user.getUserId());
			if (prePassword.equals(user.getPassword())) {
				try {
					userService.editUser(user);
				} catch (Exception e) {
					code = Constants.FAILED;
					msg = "操作失败";
					e.printStackTrace();
				}
			} else {
				code = Constants.FAILED;
				msg = "原密码错误";
			}
			return new ReturnVoOne<User>(code, msg);
		} else if (StringUtils.isNotEmpty(user.getRealname())) {// 编辑
			if (user.getRealname().length() < 11) {
				// 用户类型判断
				if ("ADMIN".equals(user.getUserType())) {
					user.setUserType(Constants.ADMIN);
				} else if ("TEACHER".equals(user.getUserType())) {
					user.setUserType(Constants.TEACHER);
				} else if ("STUDENT".endsWith(user.getUserType())) {
					user.setUserType(Constants.STUDENT);
				} else {
					return new ReturnVoOne<User>(Constants.FAILED, "用户类型错误");
				}
				try {
					userService.editUser(user);
				} catch (Exception e) {
					e.printStackTrace();
					code = Constants.FAILED;
					msg = "操作失败";
				}
				return new ReturnVoOne<User>(code, msg);
			} else {
				return new ReturnVoOne<User>(Constants.FAILED, "姓名格式不正确");
			}
		} else {
			return new ReturnVoOne<User>(Constants.FAILED, "姓名不能为空");
		}
	}

	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping("/token/hasexpire")
	public ReturnVoOne tokenHasExpire() {
		// 过滤器已经校验了token
		return new ReturnVoOne();
	}

}
