package com.king.common.util;


import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 配置文件工具类,允许读取属性文件中的重复key
 * 
 * @author 张云鹏 2011-11-29
 * 
 */
public class ConfigUtils {
	
	private static Logger log = LoggerFactory.getLogger(ConfigUtils.class);
	private static Configuration config = null;
	static {
		try {
			config = new PropertiesConfiguration("config/dev/sys.properties");
		} catch (ConfigurationException e) {
			if(log.isErrorEnabled()){
				log.error("ConfigurationException:",e);
			}
		}
	}
	
	/**
	 * 获取BigDecimal类型的数据
	 * 
	 * @param key
	 * @return 返回BigDecimal
	 */
	public static BigDecimal getBigDecimal(String key) {
		return config.getBigDecimal(key);
	}

	/**
	 * 获取BigDecimal类型的数据,如果没有获取到，返回默认值
	 * 
	 * @param key
	 * @param defaults 默认值
	 * @return
	 */
	public static BigDecimal getBigDecimal(String key, BigDecimal defaults) {
		return config.getBigDecimal(key, defaults);
	}

	/**
	 * 获取boolean类型的数据
	 * 
	 * @param key
	 * @return 返回boolean型
	 */
	public static boolean getBoolean(String key) {
		return getBoolean(key, false);
	}

	/**
	 * 获取boolean类型的数据，如果获取不到，返回默认值
	 * 
	 * @param key
	 * @param defaults 默认值
	 * @return
	 */
	public static boolean getBoolean(String key, boolean defaults) {
		return config.getBoolean(key, defaults);
	}

	/**
	 * 获取String类型的数据
	 * 
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		return getString(key, null);
	}

	/**
	 * 获取String类型的数据，获取不到，返回默认值
	 * 
	 * @param key
	 * @param defaults
	 * @return
	 */
	public static String getString(String key, String defaults) {
		return config.getString(key, defaults);
	}

	/**
	 * 获取整型
	 * 
	 * @param key
	 * @return
	 */
	public static int getInt(String key) {
		return config.getInt(key);
	}

	/**
	 * 获取整型，如果获取不到，返回默认值
	 * 
	 * @param key
	 * @param defaults  如果获取不到，返回默认值
	 * @return
	 */
	public static int getInt(String key, int defaults) {
		return config.getInt(key, defaults);
	}

	/**
	 * 获取长整型
	 * 
	 * @param key
	 * @return
	 */
	public static long getLong(String key) {
		return getLong(key, 0L);
	}

	/**
	 * 获取长整型，如果获取不到，返回默认值
	 * 
	 * @param key
	 * @param defaults 如果获取不到，返回默认值
	 * @return
	 */
	public static long getLong(String key, long defaults) {
		return config.getLong(key, defaults);
	}

	/**
	 * 获取集合数据，允许在Properties文件中用相同的key配置
	 * 
	 * @param key
	 * @return
	 */
	public static List<Object> getList(String key) {
		List<Object> list = (List<Object>) config.getList(key);
		return list;
	}

}