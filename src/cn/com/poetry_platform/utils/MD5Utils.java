package cn.com.poetry_platform.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5
 */
public class MD5Utils {

    /**
     * MD5加密。
     * @param string
     * @return
     */
    public static String stringToMD5(String string) {

        if(StringUtils.isEmpty(string)) {
            return "";
        }

        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(string.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }

        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }

        return md5code;
    }

    public static void main(String[] args) {
        System.out.println(stringToMD5("123456"));
    }
}