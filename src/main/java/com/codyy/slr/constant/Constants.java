package com.codyy.slr.constant;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.codyy.slr.util.ConfigUtils;

public class Constants {

	public static final int SUCCESS = 1;
	public static final int FAILED = 0;
	public static final int NOT_LOGGIN = 2;

	public static final List<String> DELETE = Arrays.asList("del_fun");
	public static final List<String> EDIT = Arrays.asList("edit_fun");
	public static final List<String> EDIT_DELETE = Arrays.asList("edit_fun", "del_fun");
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
	 * 文件夹分割付
	 */
	public static final String PATH_SEPARATOR = "/";

	/**
	 * 视频类型
	 */
	public static final String VIDEO_FLV = ".flv";

	/**
	 * token过期时间
	 */
	public static final long EXPIRE_TIME;

	/**
	 * 存储路径
	 */
	public final static String IMG_PATH;
	public final static String LIVE_PATH;
	public final static String UPLOAD_PATH;
	public final static String TEMP;
	public final static String DMS_VIDEO_PATH;

	/**
	 * 系统截图张数
	 */
	public static final int SHOT_NUM;

	/**
	 * 截图超时时间
	 */
	public final static int SHOT_IMG_TIME;

	/**
	 * 截图失败尝试次数
	 */
	public final static int SHOT_IMG_TIMES;

	/**
	 * 合并超时时间
	 */
	public final static int CONCAT_VIDEO_TIME;

	/**
	 * 合并失败尝试次数
	 */
	public final static int CONCAT_VIDEO_TIMES;

	static {
		if (StringUtils.isNumeric(ConfigUtils.getValue("expireTime"))) {
			EXPIRE_TIME = Long.parseLong(ConfigUtils.getValue("expireTime"));
		} else {
			EXPIRE_TIME = 30L;
		}

		IMG_PATH = ConfigUtils.getValue("img.path");
		LIVE_PATH = ConfigUtils.getValue("video.live.path");
		UPLOAD_PATH = ConfigUtils.getValue("video.upload.path");
		TEMP = ConfigUtils.getValue("temp.path");
		DMS_VIDEO_PATH = ConfigUtils.getValue("dms.video.path");

		SHOT_NUM = StringToInt("sys.screen.shot", 9);
		SHOT_IMG_TIME = StringToInt("shot.img.time", 60);
		SHOT_IMG_TIMES = StringToInt("shot.img.times", 5);
		CONCAT_VIDEO_TIME = StringToInt("concat.video.time", 3600);
		CONCAT_VIDEO_TIMES = StringToInt("concat.video.times", 5);
	}

	private static int StringToInt(String key, int defaultVal) {
		if (StringUtils.isNumeric(ConfigUtils.getValue(key))) {
			return  Integer.parseInt(ConfigUtils.getValue(key));
		} else {
			return defaultVal;
		}
	}
}
