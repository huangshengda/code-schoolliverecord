package com.codyy.slr.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 配置文件
 * 
 * @author huangshengda
 *
 */
public class ConfigUtils {

	private static final Log logger = LogFactory.getLog(ConfigUtils.class);

	private static final String CONFIG_PROPERTIES = "config.properties";

	private static final Map<String, String> map = new HashMap<String, String>();

	static {
		InputStream in = ConfigUtils.class.getClassLoader().getResourceAsStream(ConfigUtils.CONFIG_PROPERTIES);
		Properties properties = new Properties();
		try {
			properties.load(in);
			Set<Entry<Object, Object>> entrys = properties.entrySet();
			for (Entry<Object, Object> entry : entrys) {
				map.put(entry.getKey().toString(), entry.getValue().toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("load upload.properties wrong");
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 依据key获取对应的value
	 * @param key
	 * @return
	 */
	public static String getValue(String key){
		String value = null;
		String keyValue = map.get(key);
		if(StringUtils.isNotBlank(keyValue)){
			value = keyValue.trim();
		}
		return value;
	}
}
