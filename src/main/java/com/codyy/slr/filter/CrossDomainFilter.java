package com.codyy.slr.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @Description: 解决跨域(过滤器)  
 * @author huangshengda  
 * @date 2016年12月6日   
 *
 */
public class CrossDomainFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;

		// 环境部署时 nginx中已经设置了 Access-Control-Allow-Origin 就不用加了
		if (rep.getHeader("Access-Control-Allow-Origin") == null) {
			rep.setHeader("Access-Control-Allow-Origin", "*");
		}
		rep.setHeader("Access-Control-Allow-Methods", "GET,POST");

		// 如果请求为OPTIONS,那说明是浏览器对服务器的查询
		String method = req.getMethod();
		if ("OPTIONS".equals(method) || "options".equals(method)) {
			return;
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {

	}
}
