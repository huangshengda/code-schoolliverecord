package com.codyy.slr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.User;
import com.codyy.slr.vo.ReturnVoOne;

/**  
 * @Description: 菜单信息
 * @author huangshengda  
 * @date 2016年12月13日   
 *  
*/
@Controller
public class MenuController {

	@RequestMapping("menu")
	@ResponseBody
	public ReturnVoOne<List<String>> getMenu(HttpServletRequest req) {
		ReturnVoOne<List<String>> one = new ReturnVoOne<List<String>>();
		try {

			User user = (User) req.getAttribute("user");
			if (Constants.ADMIN.equalsIgnoreCase(user.getUserType())) {
				one.setData(Constants.COLUMN_BASE);
			} else if (Constants.TEACHER.equalsIgnoreCase(user.getUserType())) {
				one.setData(Constants.COLUMN_MY_COURSE);
			} else {
				one.setData(Constants.COLUMN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			one.setCode(Constants.FAILED);
			one.setMsg("获取菜单失败");
		}
		return one;
	}
}
