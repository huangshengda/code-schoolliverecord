package com.codyy.slr.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.User;
import com.codyy.slr.util.TokenUtils;
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

	@RequestMapping("menu")
	@ResponseBody
	public ReturnVoOne<List<MenuVo>> getMenu(HttpServletRequest req) {

		List<MenuVo> list = new ArrayList<>(Arrays.asList(Constants.INDEX_MENU, Constants.DEMAND_MENU));
		ReturnVoOne<List<MenuVo>> one = new ReturnVoOne<List<MenuVo>>();
		one.setData(list);
		try {
			String token = req.getHeader("token");
			if (StringUtils.isEmpty(token)) {
				token = req.getParameter("token");
			}

			if (StringUtils.isEmpty(token)) {
				return one;
			}

			String agent = req.getHeader("User-Agent");
			User user = TokenUtils.getUserFromCache(token + agent);
			if (user == null || "0".equals(user.getUserId())) {
				return one;
			}

			if (Constants.ADMIN.equalsIgnoreCase(user.getUserType()) || Constants.SUPER_ADMIN.equalsIgnoreCase(user.getUserType())) {
				list.add(Constants.BASIC_MENU);
			} else if (Constants.TEACHER.equalsIgnoreCase(user.getUserType())) {
				list.add(Constants.MYCOURSE_MENU);
			}
		} catch (Exception e) {
			e.printStackTrace();
			one.setCode(Constants.FAILED);
			one.setMsg("获取菜单失败");
		}
		return one;
	}

}
