package cn.com.poetry_platform.utils;

import java.util.Date;
import java.util.UUID;

/**
 * 字符串的工具类。
 */
public class StringUtils {

    /**
     * 判断字符串是否为空。
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {

        if (str == null || "".equals(str.trim())) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串不为空。
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {

        if (str != null && !"".equals(str.trim())) {
            return true;
        }
        return false;
    }

    /**
     * 使用UUID来重命名文件的名称，保证不重复。
     *
     * @param fileName
     * @return
     */
    public static String uniqueFileName(String fileName) {

        if (isEmpty(fileName)) {
            return null;
        }

        int typeIndex = fileName.lastIndexOf(".");
        String fileType = fileName.substring(typeIndex, fileName.length());
        // System.out.println(fileType);
        // 2、来一个不重复的文件名
        // new Date().getTime(); 时间戳不是最安全的。
        String uuid = UUID.randomUUID().toString();
        // System.out.println(uuid);
        fileName = uuid + fileType;
        return fileName;
    }

    public static void main(String[] args) {

        String fileName = "icon.jpg";
        // 步骤：1、获取文件的后缀名
        // 为了截取文件的后缀
        System.out.println(uniqueFileName(fileName));
    }
}
