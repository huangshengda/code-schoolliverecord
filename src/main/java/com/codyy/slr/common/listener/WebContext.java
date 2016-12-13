package com.codyy.slr.common.listener;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**  
 * @Description: 保存response  request  
 * @author huangshengda  
 * @date 2016年12月13日   
 *  
*/
public class WebContext {

	private static final Logger logger = Logger.getLogger(WebContext.class);
	/**
	 * 储存request对象
	 */
	private static ThreadLocal<HttpServletRequest> requestLocal = new ThreadLocal<HttpServletRequest>();
	/**
	 * 储存response对象
	 */
	private static ThreadLocal<HttpServletResponse> responseLocal = new ThreadLocal<HttpServletResponse>();

	/**
	 * @author xierongbing
	 * @date 2016年4月22日 上午8:25:24
	 * @description  设置request到当前的线程
	 */
	public static void setRequest(HttpServletRequest req) {
		requestLocal.set(req);
	}

	/**
	 * @author xierongbing
	 * @date 2016年4月22日 上午8:25:24
	 * @description  设置response到当前的线程
	 */
	public static void setResponse(HttpServletResponse rep) {
		responseLocal.set(rep);
	}

	/**
	 * @author xierongbing
	 * @date 2016年4月21日 下午8:22:56
	 * 获取当前的request
	 */
	public static HttpServletRequest getRequest() {
		return requestLocal.get();
	}

	/**
	 * @author xierongbing
	 * @date 2016年4月21日 下午8:22:56
	 * 获取当前的response
	 */
	public static HttpServletResponse getReponse() {
		return responseLocal.get();
	}

	/**
	 * =======================================================================================================================
	 * 往下内容是一些工具方法
	 */
	/**
	 * 往request中设置值
	 */
	public static void setAttribute(String key, Object obj) {
		getRequest().setAttribute(key, obj);
	}

	/**
	 * 用于写str返回
	 */
	public static void write(String str) {
		try {
			getReponse().setCharacterEncoding("UTF-8");
			getReponse().setContentType("application/json; charset=utf-8");
			getReponse().getWriter().write(str);
			logger.info("response data : " + str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
