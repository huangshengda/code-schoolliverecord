package com.codyy.slr.util;

import javax.servlet.http.HttpServletRequest;

public class HostConfigUtils {
	/**
	 * 依据HttpServletRequest 获取host地址
	 * @param req
	 * @return
	 */
	public static String getHost(HttpServletRequest req) {
		return req.getScheme() + "://" + req.getServerName() + ":"
				+ req.getServerPort() + req.getContextPath();
	}
}
