package cn.com.poetry_platform.utils;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

/**
 * 日志初始化类
 * 
 * @author Administrator
 * 
 */
public class LogConfig {

	/**
	 * 初始化日志。
	 * @param logPath
	 *            logback.xml的路径
	 */
	public static void init(String logPath) {

		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		JoranConfigurator conf = new JoranConfigurator();
		conf.setContext(lc);
		lc.reset();
		try {
			conf.doConfigure(logPath);
		} catch (JoranException e) {
			e.printStackTrace();
			System.out.println("Fatal error! init logback failure.");
			System.exit(-1);
		}
	}
}