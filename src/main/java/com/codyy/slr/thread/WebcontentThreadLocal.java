package com.codyy.slr.thread;

import javax.servlet.http.HttpServletRequest;

/**  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author huangshengda  
 * @date 2016年12月13日   
 *  
*/
public class WebcontentThreadLocal {
	private static ThreadLocal<HttpServletRequest> threadLocal = new ThreadLocal<HttpServletRequest>();

	public static HttpServletRequest getVal() {
		return threadLocal.get();
	}

	public static void setVal(HttpServletRequest req) {
		threadLocal.set(req);
	}
}
