package com.codyy.slr.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codyy.slr.common.page.Page;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.dao.UserMapper;
import com.codyy.slr.entity.User;
import com.codyy.slr.util.SecurityUtils;
import com.codyy.slr.util.StringUtils;
import com.codyy.slr.util.UUIDUtils;
import com.codyy.slr.util.Validation;
import com.codyy.slr.util.doc.ExcelAnnocationUtils;
import com.codyy.slr.util.doc.ExcelUtils;
import com.codyy.slr.vo.ReturnVoOne;
import com.codyy.slr.vo.UserExportModel;
import com.codyy.slr.vo.UserImporErroModel;
import com.codyy.slr.vo.UserImportModel;
import com.codyy.slr.vo.ValueBean;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	final String PasswordRegex = "^[0-9a-zA-Z|,|.|;|~|!|@|@|#|$|%|\\^|&|*|(|)|_|+|\\-|=|\\\\|/|<|>]{6,18}$";
	final String userNameRegex = "^[\u4E00-\u9FA5,0-9a-zA-Z|,|.|;|~|!|@|@|#|$|%|\\^|&|*|(|)|_|+|\\-|=|\\\\|/|<|>]{2,18}$";

	private static final Logger log = Logger.getLogger(UserService.class);

	/**
	 * 
	 * @Description: 获取deleteFlag为N的用户,
	 * 				根据不同登录者类型返回不同操作项
	 * @param page
	 * @return
	 *
	 */
	public Page getUserList(Page page) {
		User userLogin;
		List<User> userList = userMapper.getUserListPageList(page);
		if ((User) page.getMap().get("user") != null) {
			userLogin = (User) page.getMap().get("user");
			for (Iterator<User> userIter = userList.iterator(); userIter.hasNext();) {
				User user = userIter.next();
				if (Constants.SUPER_ADMIN.equals(userLogin.getUserType())) {
					if (Constants.SUPER_ADMIN.equals(user.getUserType())) {
						user.setOpt(null);
					} else {
						user.setOpt(Constants.EDIT_DELETE);
					}
				} else {
					if (user.getUserId().equals(userLogin.getUserId())) {
						user.setOpt(Constants.EDIT);
					} else {
						user.setOpt(Constants.EDIT_DELETE);
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

	/**
	 * 
	 * @Description: 根据用户名或密码查找用户
	 * @param map
	 * @return
	 *
	 */
	public User getUserByUserNameAndPw(Map<String, Object> map) {
		List<User> list = userMapper.getUserByNameAndPw(map);
		if (list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	public ReturnVoOne<User> importUser(String tempPath, String basePath, String excelType, String loginUserType) {
		File file = new File(tempPath);
		InputStream in = null;
		if (!file.exists()) {
			return new ReturnVoOne<User>(Constants.FAILED, "导入失败！");
		}
		List<Object> list = new ArrayList<Object>();
		try {
			in = new FileInputStream(file);
			if (StringUtils.equals(excelType, ExcelUtils.EXCEL_TYPE_XLS)) {
				list = new ExcelUtils().importExcelData(in, UserImportModel.class);
			} else {
				list = new ExcelUtils().importExcelData2007(in, UserImportModel.class);
			}
			in.close();
		} catch (Exception e) {
			log.error(e.toString());
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e1) {
				log.error(e1.toString());
			}
			return new ReturnVoOne<User>(Constants.FAILED, "导入失败！");
		}
		UserImportModel orgUser;
		boolean canInsert = true;
		String username;
		String realname;
		String password;
		String userType;
		String message;
		Map<String, String> tempuser = new HashMap<String, String>();
		int size = list.size();
		List<UserImporErroModel> errorList = new ArrayList<UserImporErroModel>();
		UserImporErroModel errorModel;
		ValueBean valueBean;

		// 查询用户名是否存在参数
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		for (int i = 0; i < size; i++) {
			paramsMap.clear();
			errorModel = new UserImporErroModel();
			orgUser = (UserImportModel) list.get(i);
			username = orgUser.getUsername();
			valueBean = new ValueBean(username);
			username = strTrim(username);
			paramsMap.put("username", username);
			if (username.matches(userNameRegex)) {
				paramsMap.put("username", username);
				if (getUserByUserNameAndPw(paramsMap) != null) {
					message = "#用户名称已存在！";
					canInsert = false;
					valueBean.valueAppend(message);
				}
				if (userNameCheck(username, tempuser)) {
					message = "#用户名与第" + tempuser.get(username) + "行用户名相同！";
					canInsert = false;
					valueBean.valueAppend(message);
				} else {
					tempuser.put(username, (i + 1) + "");
					orgUser.setUsername(StringUtils.replaceEscapeCharRollback(username));
				}
			} else {
				message = "#用户名长度为2到18个字符！";
				canInsert = false;
				valueBean.valueAppend(message);
			}
			errorModel.setUserName(valueBean);
			// 密码
			password = strTrim(orgUser.getPassword());
			valueBean = new ValueBean(password);
			password = getPassword(password);
			if (password.matches(PasswordRegex)) {
				orgUser.setPassword(SecurityUtils.MD5String(password));
			} else {
				message = "#数据格式错误！";
				canInsert = false;
				valueBean.valueAppend(message);
			}
			errorModel.setPassword(valueBean);

			// 姓名
			realname = orgUser.getRealname();
			valueBean = new ValueBean(realname);
			realname = strTrim(realname);
			if (Validation.strValidate(realname, 1, 10, true)) {
				orgUser.setRealname(StringUtils.replaceEscapeCharRollback(realname));
			} else {
				message = "#姓名长度限制10个字！";
				canInsert = false;
				valueBean.valueAppend(message);
			}
			errorModel.setRealname(valueBean);

			// 用户类型
			userType = orgUser.getUserType();
			valueBean = new ValueBean(userType);
			userType = strTrim(userType);
			switch (userType) {
			case "教师":
				userType = "TEACHER";
				break;
			case "学生":
				userType = "STUDENT";
				break;
			case "管理员":
				if (Constants.SUPER_ADMIN.equals(loginUserType)) {
					userType = "ADMIN";
				} else {
					message = "#用户权限不够，不能添加管理员";
					canInsert = false;
					valueBean.valueAppend(message);
				}
				break;
			default:
				message = "#用户类型错误！";
				canInsert = false;
				valueBean.valueAppend(message);
			}
			errorModel.setUserType(valueBean);

			orgUser.setUserType(userType);
			orgUser.setUserId(UUIDUtils.getUUID());
			orgUser.setCreateTime(new Date());
			errorList.add(errorModel);
		}
		if (canInsert) {
			if (size == 0) {
				return new ReturnVoOne<User>(Constants.FAILED, "导入失败，导入的数据为空！");
			}
			userMapper.insertUsers(list);

			return new ReturnVoOne<User>();
		} else {
			String fileName = UUIDUtils.getUUID() + ".xls";
			try {
				OutputStream ou = new FileOutputStream(new File(basePath, fileName));
				ExcelAnnocationUtils.exportExcelErrData(UserImporErroModel.class, errorList).write(ou);
				ou.close();
				errorList = null;
			} catch (Exception e) {
				log.error(e.toString());
				return new ReturnVoOne<User>(Constants.FAILED, "导入失败！");
			}
			return new ReturnVoOne<User>(Constants.UPLOAD_BATCHUSER_ERROR, fileName);
		}
	}

	private boolean userNameCheck(String userName, Map<String, String> userMap) {
		if (userMap.get(userName) == null) {
			return false;
		} else {
			return true;
		}
	}

	private String getPassword(String password) {
		if (StringUtils.isEmpty(password)) {
			password = "666666";
		}
		return password;
	}

	private String strTrim(String str) {
		if (StringUtils.isBlank(str)) {
			return "";
		} else {
			return str.trim();
		}
	}

	public HSSFWorkbook getStudentListForExport(Map<String, Object> map) {
		List<UserExportModel> userExportList = userMapper.getUserExportList(map);
		for (UserExportModel user : userExportList) {
			user.setUsername(StringUtils.replaceEscapeChar(user.getUsername()));
			user.setRealname(StringUtils.replaceEscapeChar(user.getRealname()));
		}
		return ExcelAnnocationUtils.exportExcelData(UserExportModel.class, userExportList);
	}

}
