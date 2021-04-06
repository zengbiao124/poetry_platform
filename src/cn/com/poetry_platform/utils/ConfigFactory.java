package cn.com.poetry_platform.utils;

import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

/**
 * 配置文件初始化
 *
 * @author Administrator
 *
 */
public class ConfigFactory {

	private static XMLConfiguration config;

	/**
	 * 初始化配置
	 *
	 * @param configPath
	 *            xml文件的路径
	 */
	public static void init(String configPath) {

		try {
			XMLConfiguration.setDefaultListDelimiter('>');
			config = new XMLConfiguration(configPath);
			// 当xml文件发生变化的时候自动重新解析。
			config.setReloadingStrategy(new FileChangedReloadingStrategy());
		} catch (ConfigurationException e) {
			e.printStackTrace();
			System.out.println("Fatal error! init config failure.");
			//System.exit(-1);
		}
	}

	/**
	 * 获取配置文件里面的字符串
	 *
	 * @param path
	 * @return
	 */
	public static List<Object> getList(String path) {
		return config.getList(path, null);
	}

	/**
	 * 获取配置文件里面的字符串
	 *
	 * @param path
	 * @return
	 */
	public static String getString(String path) {
		return config.getString(path, null);
	}

	/**
	 * 获取配置文件里面的字符串，带默认值
	 *
	 * @param path
	 * @return
	 */
	public static String getString(String path, String defaultValue) {
		return config.getString(path, defaultValue);
	}

	/**
	 * 获取配置文件里面的整型
	 *
	 * @param path
	 * @return
	 */
	public static int getInt(String path) {
		return config.getInt(path, 0);
	}

	/**
	 * 获取配置文件里面的整型，带默认值
	 *
	 * @param path
	 * @return
	 */
	public static int getInt(String path, int defaultValue) {
		return config.getInt(path, defaultValue);
	}

	/**
	 * 获取配置文件里面的长整型
	 *
	 * @param path
	 * @return
	 */
	public static long getLong(String path) {
		return config.getLong(path, 0l);
	}

	/**
	 * 获取配置文件里面的长整型，带默认值
	 *
	 * @param path
	 * @return
	 */
	public static long getLong(String path, long defaultValue) {
		return config.getLong(path, defaultValue);
	}

	/**
	 * 获取配置文件里面的单精度
	 *
	 * @param path
	 * @return
	 */
	public static float getFloat(String path) {
		return config.getFloat(path, 0f);
	}

	/**
	 * 获取配置文件里面的单精度，带默认值
	 *
	 * @param path
	 * @return
	 */
	public static float getFloat(String path, float defaultValue) {
		return config.getFloat(path, defaultValue);
	}

	/**
	 * 获取配置文件里面的双精度
	 *
	 * @param path
	 * @return
	 */
	public static double getDouble(String path) {
		return config.getDouble(path, 0d);
	}

	/**
	 * 获取配置文件里面的双精度，带默认值
	 *
	 * @param path
	 * @return
	 */
	public static double getDouble(String path, double defaultValue) {
		return config.getDouble(path, defaultValue);
	}

	/**
	 * 获取配置文件里面的布尔值
	 *
	 * @param path
	 * @return
	 */
	public static boolean getBoolean(String path) {
		return config.getBoolean(path, false);
	}

	/**
	 * 获取配置文件里面的布尔值，带默认值
	 *
	 * @param path
	 * @return
	 */
	public static boolean getBoolean(String path, boolean defaultValue) {
		return config.getBoolean(path, defaultValue);
	}
}