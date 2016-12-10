package com.codyy.slr.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.codyy.slr.constant.Constants;
import com.codyy.slr.entity.User;
import com.codyy.slr.thread.ConfigThreadLocal;
import com.codyy.slr.util.TokenUtils;
import com.codyy.slr.vo.ReturnVoOne;

/**
 * 
 * @Description: Token过滤器(用户验证)  
 * @author huangshengda  
 * @date 2016年12月6日   
 *
 */
public class TokenFilter implements Filter {
	// 不需要过滤的路径
	private List<String> excludePath;

	// 不需要过滤的后缀
	// private List<String> excludeSuffix;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		excludePath = initNotFilterUrl(filterConfig, "excludePath");
		// excludeSuffix = initNotFilterUrl(filterConfig, "excludeSuffix");
	}

	@Override
	public void destroy() {
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		// 添加项目路径
		req.setAttribute("ROOT_UI", Constants.ROOT_UI);
		req.setAttribute("ROOT_SERVER", Constants.ROOT_SERVER);
		req.setAttribute("ROOT_CHAT", Constants.ROOT_CHAT);

		String uri = req.getRequestURI();

		if (uri.indexOf("/chat/") != -1) {
			ConfigThreadLocal.setVal(req.getHeader("User-Agent"));
			System.out.println(ConfigThreadLocal.getVal());
			chain.doFilter(req, resp);
			return;
		}

		// 登录首页路径
		String contenxtPath = req.getContextPath() + "/";
		if (uri.endsWith(contenxtPath)) {
			chain.doFilter(req, resp);
			return;
		}

		if (uri.indexOf(".") != -1) { // 不等于-1 的路径都是取静态资源 或者图片
			for (String path : Constants.STATIC_RES_PATH_PREFIX) {
				if (uri.indexOf(path) != -1) {
					chain.doFilter(req, resp);
					return;
				}
			}
		}

		for (String string : excludePath) {
			if (uri.endsWith(string)) {
				chain.doFilter(req, resp);
				return;
			}
		}

		// 先从header中取token,如果没有再从参数中取
		String token = req.getHeader("token");
		if (StringUtils.isEmpty(token)) {
			token = req.getParameter("token");
		}

		if (StringUtils.isEmpty(token)) {
			resp.setContentType("text/html;charset=UTF-8");
			resp.getWriter().write(JSONObject.toJSONString(new ReturnVoOne(Constants.FAILED, "请传token参数")));
			return;
		}

		try {
			// token+agent 作为key 增加破解难度
			String agent = req.getHeader("User-Agent");
			User user = TokenUtils.getUserFromCache(token + agent);
			if (user == null || "0".equals(user.getUserId())) {
				resp.setContentType("text/html;charset=UTF-8");
				resp.getWriter().write(JSONObject.toJSONString(new ReturnVoOne(Constants.NOT_LOGGIN, "未登陆")));
				return;
			}
			req.setAttribute("user", user);
			chain.doFilter(req, resp);
		} catch (ExecutionException e) {
			resp.setContentType("text/html;charset=UTF-8");
			resp.getWriter().write(JSONObject.toJSONString(new ReturnVoOne(Constants.FAILED, "请求失败")));
			e.printStackTrace();
		}
	}

	private List<String> initNotFilterUrl(FilterConfig filterConfig, String param) {
		String excludePath = filterConfig.getInitParameter(param);
		String[] paths = excludePath.trim().split(";");

		List<String> list = new ArrayList<String>();
		for (String path : paths) {
			list.add(path);
		}
		return list;
	}

}
