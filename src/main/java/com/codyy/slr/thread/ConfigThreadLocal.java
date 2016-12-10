package com.codyy.slr.thread;

/**  
 * @Description: 当前线程保存变量  
 * @author huangshengda  
 * @date 2016年12月9日   
 *  
*/
public class ConfigThreadLocal {

	private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

	public static String getVal() {
		return threadLocal.get();
	}

	public static void setVal(String val) {
		threadLocal.set(val);
	}

}
