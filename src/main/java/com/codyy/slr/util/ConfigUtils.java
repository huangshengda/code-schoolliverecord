package com.codyy.slr.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 配置文件
 * 
 * @author huangshengda
 *
 */
public class ConfigUtils {

	private static final Logger log = Logger.getLogger(ConfigUtils.class);

	private static final String DEPLOY_CONFIG_PROPERTIES = "deploy-config.properties";

	private static final String OPERATION_CONFIG_PROPERTIES = "operation-config.properties";

	private static final Map<String, String> map = new HashMap<String, String>();

	static {
		InputStream deployIn = ConfigUtils.class.getClassLoader().getResourceAsStream(ConfigUtils.DEPLOY_CONFIG_PROPERTIES);
		InputStream operationIn = ConfigUtils.class.getClassLoader().getResourceAsStream(ConfigUtils.OPERATION_CONFIG_PROPERTIES);
		Properties properties = new Properties();
		try {
			properties.load(deployIn);
			properties.load(operationIn);
			Set<Entry<Object, Object>> entrys = properties.entrySet();
			for (Entry<Object, Object> entry : entrys) {
				map.put(entry.getKey().toString(), entry.getValue().toString());
			}
		} catch (IOException e) {
			log.error("load upload.properties wrong");
			log.error(e.toString());
		} finally {
			try {
				deployIn.close();
				operationIn.close();
			} catch (IOException e) {
				log.error(e.toString());
			}
		}
	}

	/**
	* 依据key获取对应的value
	* @param key
	* @return
	*/
	public static String getValue(String key) {
		String value = null;
		String keyValue = map.get(key);
		if (StringUtils.isNotBlank(keyValue)) {
			value = keyValue.trim();
		}
		return value;
	}
}
