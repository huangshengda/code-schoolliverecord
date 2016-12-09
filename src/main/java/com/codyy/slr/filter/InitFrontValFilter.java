package com.codyy.slr.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.codyy.slr.constant.Constants;

public class InitFrontValFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 添加网站路径
		request.setAttribute("rootUI", Constants.ROOT_UI);
		request.setAttribute("rootServer", Constants.ROOT_SERVER);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
