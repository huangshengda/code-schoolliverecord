package com.codyy.slr.util;

import org.apache.commons.lang.StringUtils;

public class MySqlKeyWordUtils {
	
	/**
	 * mysql关键字查询转义
	 * @param str
	 * @return
	 */
	public final static String FILTER_CHAR = "/";
	
	public final static String PERCENTAGE_CHAR = "%";
	
	public final static String UNDERLINE_CHAR = "_";
	
	public static String MySqlKeyWordReplace(String str){
		if(StringUtils.isNotBlank(str)){
			return str./*replaceAll(FILTER_CHAR, FILTER_CHAR+FILTER_CHAR).*/replaceAll(PERCENTAGE_CHAR, FILTER_CHAR+PERCENTAGE_CHAR).replaceAll(UNDERLINE_CHAR, FILTER_CHAR+UNDERLINE_CHAR);
		}
		return str;
	}
	
	public static String MySqlKeyWordReplaceRollback(String str){
		if(StringUtils.isNotBlank(str)){
			return str./*replaceAll(FILTER_CHAR+FILTER_CHAR, FILTER_CHAR).*/replaceAll(FILTER_CHAR+PERCENTAGE_CHAR, PERCENTAGE_CHAR).replaceAll(FILTER_CHAR+UNDERLINE_CHAR, UNDERLINE_CHAR);
		}
		return str;
	}
}
