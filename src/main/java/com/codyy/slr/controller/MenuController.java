package com.codyy.slr.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.User;
import com.codyy.slr.vo.MenuVo;
import com.codyy.slr.vo.ReturnVoOne;

/**  
 * @Description: 菜单信息
 * @author huangshengda  
 * @date 2016年12月13日   
 *  
*/
@Controller
public class MenuController {

	private static List<MenuVo> list = Arrays.asList(Constants.INDEX_MENU, Constants.DEMAND_MENU);

	@RequestMapping("menu")
	@ResponseBody
	public ReturnVoOne<List<MenuVo>> getMenu(HttpServletRequest req) {
		ReturnVoOne<List<MenuVo>> one = new ReturnVoOne<List<MenuVo>>();
		try {

			User user = (User) req.getAttribute("user");
			if (Constants.ADMIN.equalsIgnoreCase(user.getUserType())) {
				list.add(Constants.BASIC_MENU);
			} else if (Constants.TEACHER.equalsIgnoreCase(user.getUserType())) {
				list.add(Constants.MYCOURSE_MENU);
			}
			one.setData(list);
		} catch (Exception e) {
			e.printStackTrace();
			one.setCode(Constants.FAILED);
			one.setMsg("获取菜单失败");
		}
		return one;
	}
}
