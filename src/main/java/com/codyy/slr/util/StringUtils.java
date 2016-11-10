package com.codyy.slr.util;

import java.util.Random;


/**
 * 
 * ClassName:StringUtils
 * Function: 字符串个性化处理
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {

	public static String[] oldValue = new String[]{"&lt;", "&gt;","&amp;","&apos;","&quot;"} ;
	public static String[] newValue = new String[]{"<", ">","&","'","\""} ;
	
	/**
	 * 替换特殊字符
	 * @param str
	 * @return
	 * @author zhangtian
	 */
	public static String replaceEscapeChar(String str) {
		return StringUtils.replaceEach(str, oldValue, newValue) ;
	}
	
	/**
	 * 替换特殊字符
	 * @param str
	 * @return
	 * @author zhangtian
	 */
	public static String replaceEscapeCharRollback(String str) {
		return StringUtils.replaceEach(str, newValue, oldValue) ;
	}
	
	/**
	* 生成随机码
	*
	* @param pwd_len
	* 生成的码的总长度
	* @return 密码的字符串
	*/
	public static String genRandomNum(int pwd_len) {
		// 35是因为数组是从0开始的，26个字母+10个数字
		final int maxNum = 36;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
		'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
		'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	
		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < pwd_len) {
			// 生成随机数，取绝对值，防止生成负数，
			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1
		
			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}
	
		return pwd.toString();
	}
	
	/**
	 * @author xierongbing
	 * @date 2015年7月30日 下午3:16:46
	 * @param str
	 * @return boolean
	 * @description 
	 * 如果字符串是null或者为"",就返回true,否则返回false
	 */
	public static boolean isEmpty(String str){
		return str == null || "".equals(str);
	}
	
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
	
	/**
	 * @author xierongbing
	 * @date 2015年8月12日 下午2:41:07
	 * @param str
	 * @param size
	 * @param defaultChar
	 * @return String
	 * @description
	 * 填充字符：如果过长就截取，如果过短就填充字符
	 */
	public static String fillFixedLength(String str, int size, char defaultChar){
		if(str.length() > size){
			return str.substring(0,size);
		}else if(str.length()<size){
			StringBuilder sb = new StringBuilder(str);
			for(int i=0;i<size-str.length();i++){
				sb.append(defaultChar);
			}
			return sb.toString();
		}
		return str;
	}
	
	/**
	 * @author xierongbing
	 * @date 2015年10月21日 下午2:05:30
	 * @param str
	 * @param trimValue
	 * @return String
	 * @description
	 * 用于删除字符串前后指定的字符串,只删除一次前后的字符
	 */
	public static String trimStartEnd(String str, String trimValue){
		if(str == null ||  str.length() == 0 || trimValue == null ||  trimValue.length() == 0 ){
			return str;
		}
		
		if(str.startsWith(trimValue)){
			str = str.substring(trimValue.length());
		}
		if(str.endsWith(trimValue)){
			str = str.substring(0,str.length() - trimValue.length());
		}
		return str;
	}
	/**
	 * 日期转中文
	 * toCNDaySeq
	 *
	 * @param daySeq
	 * @return
	 * @author xiongping
	 */
	public static String toCNDaySeq(int daySeq){
		String dayStr = "";
		switch (daySeq) {
		case 1:
			dayStr = " 星期一";
			break;
		case 2:
			dayStr = " 星期二";
			break;
		case 3:
			dayStr = " 星期三";
			break;
		case 4:
			dayStr = " 星期四";
			break;
		case 5:
			dayStr = " 星期五";
			break;
		case 6:
			dayStr = " 星期六";
			break;
		case 7:
			dayStr = " 星期日";
			break;
		}
		return dayStr;
	}
	/**
	 * 课程转中文
	 * toCNClassSeq
	 *
	 * @param classSeq
	 * @return
	 * @author xiongping
	 */
	public static String toCNClassSeq(int classSeq){
		String classStr = "";
		switch (classSeq) {
		case 1:
			classStr = "一";
			break;
		case 2:
			classStr = "二";
			break;
		case 3:
			classStr = "三";
			break;
		case 4:
			classStr = "四";
			break;
		case 5:
			classStr = "五";
			break;
		case 6:
			classStr = "六";
			break;
		case 7:
			classStr = "七";
			break;
		case 8:
			classStr = "八";
			break;
		}
		return classStr;
	}
	
	/**
	 * 课程转数字
	 * toCNClassSeq
	 *
	 * @param classSeq
	 * @return
	 * @author xiongping
	 */
	public static Integer toIntClassSeq(String classSeqName){
		Integer classSeq = null;
		if(equals(classSeqName, "一")){
			classSeq = 1;
		}else if(equals(classSeqName, "二")){
			classSeq = 2;
		}else if(equals(classSeqName, "三")){
			classSeq = 3;
		}else if(equals(classSeqName, "四")){
			classSeq = 4;
		}else if(equals(classSeqName, "五")){
			classSeq = 5;
		}else if(equals(classSeqName, "六")){
			classSeq = 6;
		}else if(equals(classSeqName, "七")){
			classSeq = 7;
		}else if(equals(classSeqName, "八")){
			classSeq = 8;
		}
		return classSeq;
	}
	
	/**
	 * getLowerArea:(截取区域的末级区域)
	 * @param areaName
	 * @return
	 * @author zhangtian
	 */
	public static String getLowerArea(String areaName) {
		
		if(StringUtils.isNotBlank(areaName)) {
			String[] str = areaName.split("-") ;
			return str[str.length-1] ;
		}
		return "-" ;
	}
	
	/**
	 * changeBlankToNull:(这里用一句话描述这个方法的作用)
	 * @return ""值转换为null
	 * @author zhangtian
	 */
	public static String changeBlankToNull(String str) {
		return ("".equals(str)) ? null : str ;
	}
	
	/**
	 * changeNullToBlank:(null转换为"")
	 * @return
	 * @author zhangtian
	 */
	public static String changeNullToBlank(String str) {
		return str == null ? "" : str ;
	}
	
	/**
	 * 默认为空
	 * @author xierongbing
	 * @date 2015年12月9日 下午3:19:00
	 * @param obj
	 * @return
	 * @return String
	 * @description
	 */
	public static String defaultEmpty(Object obj){
		return obj == null ? "" : obj.toString();
	}
	
	
	/**
	 * 判断小数点的长度，保留两位，未计算四舍五入
	 * <p>Description:</p>
	 * @author yaodaqing
	 * @date 2016年7月20日 下午7:23:56
	 * 
	 * @param str
	 * @return
	 */
	public static String endPointLength(String str){
		if(str == null || "".equals(str)){
			return str;
		}
		int isub = str.indexOf(".");
		if(isub == -1){
			str = str+".00";
		} else if(isub >=0) {
			String sstr = str.substring(isub+1, str.length());
			if(sstr.length()==1){
				str = str+"0";
			} else if(sstr.length() > 2){
				str = str.substring(0, isub)+"."+str.substring(isub+1, isub+3);
			}
		}
		return str;
	}
	
}
