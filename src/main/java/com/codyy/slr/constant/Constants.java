package com.codyy.slr.constant;

import java.util.Arrays;
import java.util.List;

public class Constants {
	
	public static final int SUCCESS = 1;
	public static final int FAILED = 0;
	public static final int NOT_LOGGIN = 2;
	
	
	public static final List<String> DELETE = Arrays.asList("del_fun");
	public static final List<String> EDIT = Arrays.asList("edit_fun");
	public static final List<String> EDIT_DELETE = Arrays.asList("edit_fun","del_fun");
	public static final List<String> VIEW_EDIT_DELETE = Arrays.asList("view_fun","edit_fun","del_fun");
	
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
	public static final String UPLOAD = "UPLOAD"; //上传
	public static final String RECORD = "RECORD"; //录播
	
	/**
	 * 是否
	 */
	public static final String N = "N"; 
	public static final String Y = "Y"; 
	
	/**
	 * token过期时间
	 */
	public static final String EXPIRE_TIME = "expireTime";
	
	/**
	 * 存储路径
	 */
	public static final String IMG_PATH = "img.path";
	public static final String LIVE_PATH = "video.live.path";
	public static final String UPLOAD_PATH = "video.upload.path";
}
