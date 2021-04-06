package cn.com.poetry_platform.pojo;

/**
 * 商品实体
 */
public class Goods {

    private int goodsId;

    private String name;

    private String imgUrl;

    private float price;

    private String shopName;

    private String type;

    private int flag;

    private String createTime;

    private String history_time;

    public String getHistory_time() {
        return history_time;
    }

    public void setHistory_time(String history_time) {
        this.history_time = history_time;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Goods() {
    }

    public Goods(String name, String imgUrl, float price, String shopName) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.price = price;
        this.shopName = shopName;
    }

    public Goods(int goodsId, String name, String imgUrl, float price, String shopName, String type, int flag, String createTime) {
        this.goodsId = goodsId;
        this.name = name;
        this.imgUrl = imgUrl;
        this.price = price;
        this.shopName = shopName;
        this.type = type;
        this.flag = flag;
        this.createTime = createTime;
    }

    public Goods(String name, String imgUrl, float price, String shopName, String type, int flag, String createTime) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.price = price;
        this.shopName = shopName;
        this.type = type;
        this.flag = flag;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", name='" + name + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", price='" + price + '\'' +
                ", shopName='" + shopName + '\'' +
                ", type='" + type + '\'' +
                ", flag=" + flag +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}