package com.codyy.slr.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	private static final Logger log = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

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
		// 单点登录
		if (StringUtils.isNotEmpty(req.getParameter("User-Agent"))) {
			agent = req.getParameter("User-Agent");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		int code = Constants.SUCCESS;
		String msg = "登录成功";
		if ((StringUtils.isEmpty(user.getUsername())) || (StringUtils.isEmpty(user.getPassword()))) {
			return new ReturnVoOne<User>(0, "用户名或密码为空");
		}
		map.put("username", user.getUsername());
		map.put("password", user.getPassword());
		try {
			user = userService.getUserByUserNameAndPw(map);
			if (user != null) {
				user.setToken(UUIDUtils.getUUID());
				// token+agent作为key增加破解难度
				TokenUtils.putUserIdToCache(user.getToken(), agent, user);
				// token放入session
				req.getSession().setAttribute("token", user.getToken());
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
			msg = "登录失败";
			log.error(e.toString());
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
			String agent = req.getHeader("User-Agent");
			User user = (User) req.getAttribute("user");
			TokenUtils.removeUserFormCache(user.getToken(), agent);
			// 销毁session
			req.getSession().invalidate();
		} catch (Exception e) {
			one.setMsg("退出失败");
			one.setCode(Constants.FAILED);
			log.error(e.toString());
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
		// 查询条件
		map.put("username", MySqlKeyWordUtils.MySqlKeyWordReplace(user.getUsername()));
		map.put("realname", MySqlKeyWordUtils.MySqlKeyWordReplace(user.getRealname()));
		map.put("userType", user.getUserType());
		// 登录者信息
		user = (User) req.getAttribute("user");
		map.put("loginUserType", user.getUserType());
		map.put("userId", user.getUserId());
		map.put("user", user);
		page.setMap(map);
		try {
			page = userService.getUserList(page);
		} catch (Exception e) {
			code = Constants.FAILED;
			msg = "查询失败";
			log.error(e.toString());
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
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", user.getUsername());
		int count = 0;
		if (StringUtils.isNotEmpty(user.getRealname())) {
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
			if (userService.getUserByUserNameAndPw(map) == null) {
				try {
					count = userService.addUser(user);
				} catch (Exception e) {
					log.error(e.toString());
					return new ReturnVoOne<User>(Constants.FAILED, "操作失败");
				}
			} else {
				return new ReturnVoOne<User>(Constants.FAILED, "用户名重复");
			}
			// 是否添加成功
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
			log.error(e.toString());
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
		String password;
		int code = Constants.SUCCESS;
		String msg = "操作成功";
		int count = 0;
		if (StringUtils.isNotEmpty(prePassword)) {// 修改密码
			password = user.getPassword();
			user = userService.selectByPrimaryKey(user.getUserId());
			if (prePassword.equals(user.getPassword())) {
				try {
					user.setPassword(password);
					userService.editUser(user);
				} catch (Exception e) {
					code = Constants.FAILED;
					msg = "操作失败";
					log.error(e.toString());
				}
			} else {
				code = Constants.FAILED;
				msg = "原密码错误";
			}
			return new ReturnVoOne<User>(code, msg);
		} else if (StringUtils.isNotEmpty(user.getRealname())) {// 编辑
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
				count = userService.editUser(user);
				if (count != 1) {
					code = Constants.FAILED;
					msg = "操作失败";
				}
			} catch (Exception e) {
				log.error(e.toString());
				code = Constants.FAILED;
				msg = "操作失败";
			}
			return new ReturnVoOne<User>(code, msg);
		} else {
			return new ReturnVoOne<User>(Constants.FAILED, "姓名不能为空");
		}
	}

	@ResponseBody
	@RequestMapping("/token/hasexpire")
	public ReturnVoOne<User> tokenHasExpire(HttpServletRequest req) {
		ReturnVoOne<User> one = new ReturnVoOne<User>();
		try {
			User user = (User) req.getAttribute("user");
			one.setData(user);
		} catch (Exception e) {
			one.setCode(Constants.FAILED);
			one.setMsg("出现异常");
		}
		return one;
	}

	/**
	 * 
	 * @Description: 根据token获取登录者信息
	 * @param token
	 * @param req
	 * @return
	 *
	 */
	@ResponseBody
	@RequestMapping("/token/getuser")
	public ReturnVoOne<User> getUserByToken(String token, HttpServletRequest req) {
		User user = null;
		String agent = req.getHeader("User-Agent");
		try {
			user = TokenUtils.getUserFromCache(token, agent);
			if ("TEACHER".equals(user.getUserType())) {
				user.setColumn(Constants.COLUMN_MY_COURSE);
			} else if ("STUDENT".endsWith(user.getUserType())) {
				user.setColumn(Constants.COLUMN);
			} else {
				user.setColumn(Constants.COLUMN_BASE);
			}
			user.setPassword(null);
		} catch (ExecutionException e) {
			new ReturnVoOne<User>(Constants.FAILED, "获取失败", user);
			log.error(e.toString());
		}
		return new ReturnVoOne<User>(Constants.SUCCESS, "获取成功", user);
	}

	/**
	 * 
	 * importUser:批量导入用户
	 * 
	 */
	@RequestMapping(value = "/importUser", method = RequestMethod.POST)
	@ResponseBody
	public ReturnVoOne<User> importUser(HttpServletResponse response, HttpServletRequest request, String filename, String token) {
		if (StringUtils.isEmpty(filename)) {
			return new ReturnVoOne<User>(0, "导入文件为空");
		}
		User userLogin = new User();
		String agent = request.getHeader("User-Agent");
		try {
			userLogin = TokenUtils.getUserFromCache(token, agent);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String excelType = filename.substring(filename.indexOf(".") + 1);
		String basePath = Constants.TEMP;
		String tempPath = basePath + File.separator + filename;
		ReturnVoOne<User> result = userService.importUser(tempPath, basePath, excelType, userLogin.getUserType());
		return result;
	}

	/**
	 * 
	 * downLoadErrorDetail:下载错误信息(批量上传用户时的错误)
	 */
	@RequestMapping("/downLoadErrorDetail")
	public void downLoadErrorDetail(String fileName, HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-Disposition", "attachment; filename=errorDetail.xls");
		try {
			OutputStream out = response.getOutputStream();
			String path = request.getServletContext().getRealPath("/");
			File file = new File(Constants.TEMP + File.separator + fileName);
			InputStream in = new FileInputStream(file);
			StreamUtils.copy(in, out);
			file.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 导出学生
	 * @param request
	 * @param response
	 * @throws ExecutionException 
	 */
	@RequestMapping("exporUserList")
	public void exporStutList(HttpServletRequest request, HttpServletResponse response, User user) throws ExecutionException {
		String agent = request.getHeader("User-Agent");
		User userLogin = TokenUtils.getUserFromCache(user.getToken(), agent);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", MySqlKeyWordUtils.MySqlKeyWordReplace(user.getUsername()));
		map.put("realname", MySqlKeyWordUtils.MySqlKeyWordReplace(user.getRealname()));
		map.put("userType", user.getUserType());
		map.put("loginUserType", userLogin.getUserType());
		map.put("userId", userLogin.getUserId());
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-Disposition", "attachment; filename=userExportTemplate.xls");
		try {
			OutputStream out = response.getOutputStream();
			HSSFWorkbook workbook = userService.getStudentListForExport(map);
			workbook.write(out);
		} catch (IOException e) {
			log.error(e.toString());
		}

	}

	@RequestMapping("downloadUserModel")
	public void downoadOrgUserModel(HttpServletRequest request, HttpServletResponse response) {
		String titleName = "userImportTemplate.xls";
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-Disposition", "attachment; filename=" + titleName);
		try {
			OutputStream out = response.getOutputStream();
			String path = request.getServletContext().getRealPath("/");
			File file = new File(path, "template/" + titleName);
			InputStream in = new FileInputStream(file);
			StreamUtils.copy(in, out);
		} catch (IOException e) {
			log.error(e.toString());
		}
	}
}
