package cn.com.poetry_platform.utils;

import java.util.Random;

/**
 * 随机数
 */
public class RandomUtils {

    /**
     * 产生随机数。
     *
     * @param rand
     * @return
     */
    public static int random(int rand) {
        return  new Random().nextInt(rand);
    }

    public static void main(String[] args) {
        System.out.println(random(25));
    }
}
