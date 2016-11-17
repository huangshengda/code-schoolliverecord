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
import com.codyy.slr.util.TokenUtils;
import com.codyy.slr.vo.ReturnVoOne;

public class TokenFilter implements Filter{
	//不需要过滤的路径
	private List<String> excludePath ;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		excludePath = initNotFilterUrl(filterConfig,"excludePath");
	}

	@Override
	public void destroy() {
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		
		for (String string : excludePath) {
			if(uri.indexOf(string) == -1){
				chain.doFilter(req, resp);
			}
		}
		
		//先从header中取token,如果没有再从参数中取
		String token = req.getHeader("token");
		if(StringUtils.isEmpty(token)){
			token = req.getParameter("token");
		}
		
		try {
			User user = TokenUtils.getUserToCache(token);
			if(user == null){
				resp.setContentType("text/html;charset=UTF-8");
				resp.getWriter().write(JSONObject.toJSONString(new ReturnVoOne(Constants.NOT_LOGGIN,"未登陆")));
				return; 
			}
			
			req.setAttribute("user",user);
			
			chain.doFilter(req, resp);
		} catch (ExecutionException e) {
			resp.getWriter().write(JSONObject.toJSONString(new ReturnVoOne(Constants.FAILED,"请求失败")));
			e.printStackTrace();
		}
	}
	
	private List<String> initNotFilterUrl(FilterConfig filterConfig, String param) {
		String excludePath = filterConfig.getInitParameter(param);
		String[] paths = excludePath.trim().split(";");
		
		List<String> list = new ArrayList<String>();
		for(String path : paths){
			list.add(path);
		}
		return list;
	}

}
