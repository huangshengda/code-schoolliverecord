package com.codyy.slr.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.codyy.slr.constant.Constants;

/**  
 * @Description: 初始化数据
 * @author huangshengda  
 * @date 2016年12月16日   
 *  
*/
public class InitDataFilter implements Filter {

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		// 页面判断是否登录
		HttpSession session = req.getSession();
		String sessionToken = (String) session.getAttribute("token");
		if (sessionToken != null) {
			req.setAttribute("token", sessionToken);
		}

		// 添加项目路径
		req.setAttribute("ROOT_UI", Constants.ROOT_UI);
		req.setAttribute("ROOT_SERVER", Constants.ROOT_SERVER);
		req.setAttribute("ROOT_CHAT", Constants.ROOT_CHAT);
		chain.doFilter(req, response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
	}

}
