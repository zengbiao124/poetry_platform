package cn.com.poetry_platform.listener;


import cn.com.poetry_platform.utils.ConfigFactory;
import cn.com.poetry_platform.utils.LogConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;

public class SystemListener implements ServletContextListener {

    /**
     * 系统启动的时候触发。
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        // 系统启动的时候触发。
        System.out.println("poetry_platform.........................");

        // 配置：${stj} : D:\ws\workspace2\shopping_taiji
        String path = "D:\\java\\IDEAProjects\\poetry_platform";
        // linux目录。
        // path = "/home/sinoyang/tools/web";

        // 设置：以便logback在配置文件里面使用${stj}获取路径。
        System.setProperty("stj", path);

        // 初始化配置文件
        String configPath = path + File.separator + "conf/config.xml";
        ConfigFactory.init(configPath);

        // 完成日志的初始化。
        String logPath = path + File.separator + "conf/logback.xml";
        LogConfig.init(logPath);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}