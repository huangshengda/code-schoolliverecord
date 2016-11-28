package com.codyy.slr.constant;

import java.util.Arrays;
import java.util.List;

import com.codyy.slr.util.ConfigUtils;

public class Constants {

	public static final int SUCCESS = 1;
	public static final int FAILED = 0;
	public static final int NOT_LOGGIN = 2;

	public static final List<String> DELETE = Arrays.asList("del_fun");
	public static final List<String> EDIT = Arrays.asList("edit_fun");
	public static final List<String> EDIT_DELETE = Arrays.asList("edit_fun","del_fun");
	public static final List<String> VIEW_EDIT_DELETE = Arrays.asList("view_fun", "edit_fun", "del_fun");

	/**
	 * 排序字段
	 */
	public static final String CREATE_TIME = "create_time";
	public static final String VIEW_CNT = "view_cnt";

	/**
	 * 排序类型
	 */
	public static final String DESC = "desc";
	public static final String ASC = "asc";

	/**
	 * 资源类型
	 */
	public static final String UPLOAD = "UPLOAD"; // 上传
	public static final String RECORD = "RECORD"; // 录播

	/**
	 * 图片存储目录类型
	 */
	public static final String IMG_TEMP = "temp";
	public static final String IMG_REAL = "real";

	/**
	 * 是否
	 */
	public static final String N = "N";
	public static final String Y = "Y";

	/**
	 * 直播课堂是否结束
	 */
	public static final String FINISH = "0";
	public static final String NOT_FINISH = "1";

	/**
	 * token过期时间
	 */
	public static final String EXPIRE_TIME = "expireTime";

	/**
	 * 存储路径
	 */
	public static final String IMG_PATH;
	public static final String LIVE_PATH;
	public static final String UPLOAD_PATH;
	public static final String TEMP;

	/**
	 * 系统截图张数
	 */
	public static final String SHOT_NUM;

	static {
		IMG_PATH = ConfigUtils.getValue("img.path");
		LIVE_PATH = ConfigUtils.getValue("video.live.path");
		UPLOAD_PATH = ConfigUtils.getValue("video.upload.path");
		SHOT_NUM = ConfigUtils.getValue("sys.screen.shot");
		TEMP = ConfigUtils.getValue("temp.path");
	}
}
