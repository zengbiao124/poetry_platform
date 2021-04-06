package cn.com.poetry_platform.utils;

import cn.com.poetry_platform.dao.GoodsDao;
import cn.com.poetry_platform.pojo.Goods;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用jsoup解析HTML。
 * https://search.jd.com/Search?keyword=java&page=1&s=1&click=0
 * https://search.jd.com/Search?keyword=java&page=3&s=57&click=0
 * https://search.jd.com/Search?keyword=java&page=5&s=116&click=0
 */
public class JsoupUtils {

    public static void main(String[] args) throws Exception {

        //String str = "49.96 ¥ ¥ ¥";
        //str = str.trim().replaceAll("￥", "").replaceAll(" ¥", "");
        //System.out.println(str);

        init("诗集", 2);
    }

    /**
     * @param keyword
     */
    public static void init(String keyword, int pages) throws Exception {

        String url = "https://search.jd.com/Search?keyword=";
        for (int i = 1; i < pages * 2 + 1; i = i + 2) {
            url = url + keyword + "&page=" + i;
            parseJingdong(url, keyword);
        }
    }

    /**
     * @param url
     * @return
     */
    public static void parseJingdong(String url, String type) throws Exception {

        List<Goods> goodsList = new ArrayList<Goods>();
        // 解析网页。
        Document document = Jsoup.parse(new URL(url), 20000);
        // 下面可以使用JavaScript的API。
        // <div id="J_goodsList" class="goods-list-v2 gl-type-1 J-goods-list">
        // 获取上面的div
        Element divEle = document.getElementById("J_goodsList");
        //System.out.println(divEle.html());
        // 找到div里面的li元素
        Elements lis = divEle.getElementsByTag("li");
        for (int i = 0; i < lis.size(); i++) {
            Element li = lis.get(i);
            //System.out.println(li.html());
            // 获取图片url <img width="220" height="220" data-img="1" data-lazy-img="//img11.360buyimg.com/n7/jfs/t1/145080/25/14070/214775/5faa3015E3cdfa2b5/b6fd37059d4e6002.jpg">
            String imgUrl = li.getElementsByTag("img").eq(0).attr("data-lazy-img");
            //System.out.println(imgUrl);
            // 获取价格<div class="p-price"><strong class="J_2922989"  data-done="1"  ><em>￥</em><i>75.90</i></strong></div>
            String _price = li.getElementsByClass("p-price").text().replaceAll("￥", "");
            //去掉多价格商品多余的价格
            int index=_price.indexOf(" ");
            if (index>0){
                System.out.println("存在空格，所在位置为："+index);
                _price=_price.substring(0,index);
            }

            //System.out.println(price);
            // 商品名称：<div class="p-name p-name-type-2">
            String name = li.getElementsByClass("p-name").text();
            System.out.println(name);
            // 店铺名称 <span class="J_im_icon"><a target="_blank" class="curr-shop hd-shopname" onclick="searchlog(1,'1000014803',0,58)" href="//mall.jd.com/index-1000014803.html?from=pc" title="蒙牛京东自营旗舰店">蒙牛京东自营旗舰店</a></span>
            String shopName = li.getElementsByClass("curr-shop hd-shopname").text();
            //System.out.println(shopName);
            // 封装对象。
            Goods goods = new Goods();
            goods.setImgUrl(imgUrl);
            goods.setName(name);
            _price = _price.trim().replaceAll("￥", "").replaceAll(" ¥", "");
            Float price = Float.parseFloat(_price);
            goods.setPrice(price);
            goods.setShopName(shopName);
            goods.setType(type);
            System.out.println(goods.toString());
            goodsList.add(goods);
        }
        // 批量插入数据库
        new GoodsDao().insertJDGoodsBatch(goodsList);
    }
}