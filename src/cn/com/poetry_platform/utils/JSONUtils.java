package cn.com.poetry_platform.utils;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONUtils {

    public static void main(String[] args) {


        // 支持MAP?
        Map<String, String> map = new HashMap<String, String>();
        map.put("key", "value");
        map.put("aaaa", "bbbb");
        String json2 = JSON.toJSONString(map);
        System.out.println(json2);

    }
}
