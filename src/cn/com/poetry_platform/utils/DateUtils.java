package cn.com.poetry_platform.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理工具类。
 */
public class DateUtils {

    /**
     * 格式化日期 DATE -> STRING
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * STRING -> DATE
     * @param time
     * @param format
     * @return
     */
    public static Date parseDate(String time, String format) {
        Date date = null;
        try {
            date = new SimpleDateFormat(format).parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static void main(String[] args) {

        Date date  = new Date();
        String format = "yyyy年MM月dd日HH:mm:ss";
        String time = formatDate(date, format);
        System.out.println(time);
        // 转出日期。
        Date date1 = parseDate(time, format);
        System.out.println(date1);
    }
}