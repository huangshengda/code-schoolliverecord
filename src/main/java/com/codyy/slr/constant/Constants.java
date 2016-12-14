package com.codyy.slr.constant;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.codyy.slr.util.ConfigUtils;
import com.codyy.slr.vo.MenuVo;

/**
 * 
 * @Description: 常量类  
 * @author huangshengda  
 * @date 2016年12月6日   
 *
 */
public class Constants {

	public static final int SUCCESS = 1;
	public static final int FAILED = 0;
	public static final int NOT_LOGGIN = 2;

	public static final List<String> DELETE = Arrays.asList("del_fun");
	public static final List<String> EDIT = Arrays.asList("edit_fun");
	public static final List<String> EDIT_DELETE = Arrays.asList("edit_fun", "del_fun");
	public static final List<String> VIEW_EDIT_DELETE = Arrays.asList("view_fun", "edit_fun", "del_fun");
	// 菜单
	public static final List<String> COLUMN_BASE = Arrays.asList("首页", "点播", "基础设置");// 管理员
	public static final List<String> COLUMN_MY_COURSE = Arrays.asList("首页", "点播", "我的课程");// 老师
	public static final List<String> COLUMN = Arrays.asList("首页", "点播");

	// 静态资源前缀
	public static final List<String> STATIC_RES_PATH_PREFIX = Arrays.asList("dist", "public", "pages", "download/img");

	// 用户类型
	public static final String SUPER_ADMIN = "SUPER_ADMIN";
	public static final String ADMIN = "ADMIN";
	public static final String TEACHER = "TEACHER";
	public static final String STUDENT = "STUDENT";

	public static final String SUPER_ADMIN_Chinese = "超级管理员";
	public static final String ADMIN_Chinese = "管理员";
	public static final String TEACHER_Chinese = "教师";
	public static final String STUDENT_Chinese = "学生";

	// 返回前段的路径
	public static final String FRONT_DEMOND_PATH = "pages/views/demond/demond_detail";
	public static final String FRONT_LIVE_PATH = "pages/views/live/live_detail";
	public static final String FRONT_UPLOAD_PATH = "pages/views/basic/up_subject";
	public static final String FRONT_INDEX_PATH = "pages/index";
	public static final String FRONT_DEITPWD_PATH = "pages/views/live/edit-pwd";

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
	 * 分割符号
	 */
	public static final String PATH_SEPARATOR = "/";

	/**
	 * 是否
	 */
	public static final String N = "N";
	public static final String Y = "Y";

	/**
	 * 直播课堂是否结束
	 */
	public static final String FINISH = "finish";
	public static final String NOT_FINISH = "notFinish";

	/**
	 * 视频类型
	 */
	public static final String VIDEO_FLV = ".flv";

	/**
	 * token过期时间
	 */
	public static final long EXPIRE_TIME;

	/**
	 *项目路径
	 */
	public final static String ROOT_UI;
	public final static String ROOT_SERVER;
	public final static String ROOT_CHAT;

	/**
	 * 存储路径
	 */
	public final static String IMG_PATH;
	public final static String LIVE_PATH;
	public final static String UPLOAD_PATH;
	public final static String TEMP;
	public final static String DMS_VIDEO_PATH;

	/**
	 * 系统截图张数v
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

	/**
	 * 上传视频最大值
	 */
	public final static int MAX_UPLOAD_SIZE_VIDEO;

	/**
	 * 上传图片最大值
	 */
	public final static int MAX_UPLOAD_SIZE_IMAGE;

	public final static List<String> UPLOAD_VIDEO_TYPE;

	public final static List<String> UPLOAD_IMAGE_TYPE;

	public final static MenuVo INDEX_MENU;
	public final static MenuVo DEMAND_MENU;
	public final static MenuVo BASIC_MENU;
	public final static MenuVo MYCOURSE_MENU;

	static {
		INDEX_MENU = new MenuVo(1, "首页", "/index");
		DEMAND_MENU = new MenuVo(2, "点播", "/onDemnad");
		BASIC_MENU = new MenuVo(3, "基础管理", "/basic");
		MYCOURSE_MENU = new MenuVo(4, "我的课程", "/mySubject");

		if (StringUtils.isNumeric(ConfigUtils.getValue("expireTime"))) {
			EXPIRE_TIME = Long.parseLong(ConfigUtils.getValue("expireTime"));
		} else {
			EXPIRE_TIME = 30L;
		}

		IMG_PATH = dealEndSprit("img.path");
		LIVE_PATH = dealEndSprit("video.live.path");
		UPLOAD_PATH = dealEndSprit("video.upload.path");
		TEMP = dealEndSprit("temp.path");
		DMS_VIDEO_PATH = dealEndSprit("dms.video.path");

		String uploadVideoTypeStr = ConfigUtils.getValue("upload.video.type");
		if (StringUtils.isEmpty(uploadVideoTypeStr)) {
			uploadVideoTypeStr = ".flv;.map4";
		}

		UPLOAD_VIDEO_TYPE = Arrays.asList(uploadVideoTypeStr.split(";"));

		String uploadImageTypeStr = ConfigUtils.getValue("upload.image.type");
		if (StringUtils.isEmpty(uploadImageTypeStr)) {
			uploadImageTypeStr = ".jpg;.png";
		}

		UPLOAD_IMAGE_TYPE = Arrays.asList(uploadImageTypeStr.split(";"));

		SHOT_NUM = StringToInt("sys.screen.shot", 9);
		SHOT_IMG_TIME = StringToInt("shot.img.time", 60);
		SHOT_IMG_TIMES = StringToInt("shot.img.times", 5);
		CONCAT_VIDEO_TIME = StringToInt("concat.video.time", 3600);
		CONCAT_VIDEO_TIMES = StringToInt("concat.video.times", 5);

		MAX_UPLOAD_SIZE_VIDEO = StringToInt("max.upload.size.video", 2048);
		MAX_UPLOAD_SIZE_IMAGE = StringToInt("max.upload.size.image", 5);

		ROOT_UI = dealEndSprit("root.ui");
		ROOT_SERVER = dealEndSprit("root.server");
		ROOT_CHAT = dealEndSprit("root.chat");
	}

	private static int StringToInt(String key, int defaultVal) {
		if (StringUtils.isNumeric(ConfigUtils.getValue(key))) {
			return Integer.parseInt(ConfigUtils.getValue(key));
		} else {
			return defaultVal;
		}
	}

	/**
	 * 
	 * @Description: 根据key获取路径,如果以斜杠结束将去除
	 * @param key
	 * @return
	 */
	private static String dealEndSprit(String key) {
		if (StringUtils.isNotBlank(ConfigUtils.getValue(key))) {
			return ConfigUtils.getValue(key).endsWith("/") ? StringUtils.substringBeforeLast(ConfigUtils.getValue(key), "/") : ConfigUtils.getValue(key);
		} else {
			return null;
		}
	}
}
