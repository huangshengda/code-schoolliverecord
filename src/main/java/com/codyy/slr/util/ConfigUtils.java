package com.codyy.slr.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 配置文件
 * @author huangshengda
 *
 */
public class ConfigUtils {

	private static final Log logger = LogFactory.getLog(ConfigUtils.class);
	
	private static final String CONFIG_PROPERTIES = "config.properties";
	
	private static int EXPIRE_TIME = 20;
	
	static {
		initUploadInfo();
	}
	
	private static void initUploadInfo(){
		InputStream in = ConfigUtils.class.getClassLoader().getResourceAsStream(ConfigUtils.CONFIG_PROPERTIES);
		Properties properties = new Properties();
		try {
			properties.load(in);
			EXPIRE_TIME = Integer.valueOf(properties.getProperty("expireTime"));
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("load upload.properties wrong");
		}finally{
		}
	}
	
	public static Integer getExpireTime() {
		if (EXPIRE_TIME == 0) {
			initUploadInfo();
		}
		return EXPIRE_TIME;
	}
}
