package com.codyy.slr.filter;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codyy.slr.constant.Constants;
import com.codyy.slr.util.TokenUtils;
import com.codyy.slr.vo.ReturnVoOne;

public class TokenFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
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
		String token = request.getParameter("token");
		try {
			String userId = TokenUtils.getUserToCache(token);
			if("0".equalsIgnoreCase(userId)){
				resp.getWriter().write(new ReturnVoOne(Constants.NOT_LOGGIN,"未登陆").toJson());
				return; 
			}
			
			req.setAttribute("userId",userId);
			
			chain.doFilter(request, response);
			
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
