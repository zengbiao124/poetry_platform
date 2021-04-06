package cn.com.poetry_platform.dao;

import cn.com.poetry_platform.db.C3p0ConnectionFactory;
import cn.com.poetry_platform.db.DBUtils;
import cn.com.poetry_platform.pojo.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao {

    private static Logger log = LoggerFactory.getLogger(GoodsDao.class);

    /**
     * 通过名字查询商品。
     *
     * @param name
     * @return
     */
    public List<Goods> selectGoodsName(String name) {

        log.debug("selectGoodsName(" + name + ")");
        List<Goods> list = new ArrayList<Goods>();
        String sql = "SELECT goods_id, `name`, img_url, shop_name, price, type, create_time, flag FROM t_goods WHERE name LIKE ? ORDER BY price ASC";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = C3p0ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + name + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Goods goods = new Goods();
                goods.setGoodsId(rs.getInt("goods_id"));
                goods.setName(rs.getString("name"));
                goods.setImgUrl(rs.getString("img_url"));
                goods.setShopName(rs.getString("shop_name"));
                goods.setPrice(rs.getFloat("price"));
                goods.setType(rs.getString("type"));
                goods.setFlag(rs.getInt("flag"));
                goods.setCreateTime(rs.getString("create_time"));
                list.add(goods);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("selectGoodsName={}", e.getMessage());
        } finally {
            C3p0ConnectionFactory.closeDBResource(rs, pstmt, conn);
        }

        return list;
    }

    /**
     * 通过id查询商品。
     *
     * @param id
     * @return
     */
    public Goods selectGoodsById(int id) {

        log.debug("selectGoodsById(" + id + ")");
        Goods goods = null;
        String sql = "SELECT goods_id, `name`, img_url, shop_name, price, type, create_time, flag FROM t_goods WHERE goods_id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = C3p0ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                goods = new Goods();
                goods.setGoodsId(rs.getInt("goods_id"));
                goods.setName(rs.getString("name"));
                goods.setImgUrl(rs.getString("img_url"));
                goods.setShopName(rs.getString("shop_name"));
                goods.setPrice(rs.getFloat("price"));
                goods.setType(rs.getString("type"));
                goods.setFlag(rs.getInt("flag"));
                goods.setCreateTime(rs.getString("create_time"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("selectGoodsById={}", e.getMessage());
        } finally {
            C3p0ConnectionFactory.closeDBResource(rs, pstmt, conn);
        }

        return goods;
    }

    /**
     * 批量插入京东数据。
     *
     * @param list
     * @return
     */
    public int[] insertJDGoodsBatch(List<Goods> list) {

        int ret[] = {};
        String sql = "INSERT INTO t_goods (name, img_url, price, shop_name, type) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            for (Goods goods : list) {
                if (goods.getName().length() > 0) {
                    pstmt.setString(1, goods.getName());
                    pstmt.setString(2, goods.getImgUrl());
                    pstmt.setFloat(3, goods.getPrice());
                    pstmt.setString(4, goods.getShopName());
                    pstmt.setString(5, goods.getType());
                    // 批处理
                    pstmt.addBatch();
                }
            }
            // 需要执行更新。
            ret = pstmt.executeBatch(); // 批处理。
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DBUtils.closeDBResource(null, pstmt, conn);
        }

        return ret;
    }

    /**
     * 分页查询商品
     *
     * @param start    从哪里开始查
     * @param pageSize 一夜查询几条
     * @return
     */
    public List<Goods> selectGoodsByPage(String name, int start, int pageSize, String way) {

        System.out.println("selectGoodsByPage(" + start + "," + pageSize + ")");
        List<Goods> goods = new ArrayList<Goods>();
        String sql = "SELECT goods_id, `name`, img_url, shop_name, price, type, create_time, flag FROM t_goods WHERE `name` LIKE ? ORDER BY 5 " + way + " LIMIT ?,?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = C3p0ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(sql);

            //设置参数
            pstmt.setString(1, "%" + name + "%");
            pstmt.setInt(2, start);
            pstmt.setInt(3, pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Goods good = new Goods();
                good.setGoodsId(rs.getInt("goods_id"));
                good.setName(rs.getString("name"));
                good.setImgUrl(rs.getString("img_url"));
                good.setShopName(rs.getString("shop_name"));
                good.setPrice(rs.getFloat("price"));
                good.setType(rs.getString("type"));
                good.setCreateTime(rs.getString("create_time"));
                good.setFlag(rs.getInt("flag"));
                goods.add(good);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            C3p0ConnectionFactory.closeDBResource(rs, pstmt, conn);
        }
        return goods;
    }

    /**
     * 查询商品总数
     *
     * @return
     */
    public int selectGoodsCounts(String name) {
        int counts = 0;
        String sql = "SELECT COUNT(`name`) cnt FROM t_goods WHERE `name` LIKE ? ";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = C3p0ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(sql);

            // 设置参数
            pstmt.setString(1, "%" + name + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                counts = rs.getInt("cnt");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            C3p0ConnectionFactory.closeDBResource(rs, pstmt, conn);
        }

        return counts;
    }

    /**
     * 根据关键字查询信息
     */
    public List<String> selectGoodsNameByLike(String keyword) {
        List<String> names = new ArrayList<String>();
        String sql = "SELECT name FROM t_goods WHERE name LIKE ? LIMIT 0,10";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = C3p0ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(sql);
            //参数
            pstmt.setString(1, keyword + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                names.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            C3p0ConnectionFactory.closeDBResource(rs, pstmt, conn);
        }

        return names;
    }

    /**
     * 根据用户和商品id向用户喜好表中插入用户喜好信息
     *
     * @param userId
     * @param goodsId
     * @return
     */
    public int insertLikeGoodsByUserId(int userId, int goodsId) {
        int ret = 0;
        String sql = "insert into t_like(user_id,goods_id,create_time) value(?,?,localtime)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = C3p0ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, goodsId);
            ret = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3p0ConnectionFactory.closeDBResource(null, pstmt, conn);
        }
        return ret;
    }

    /**
     * 根据用户id查询用户人气推荐的商品信息
     * 按照用户查询次数最多的以及时间最新的进行排序然后为用户推荐喜欢的商品
     *
     * @param userId
     * @return
     */
    public List<Goods> selectLikeGoodsByUserId(int userId) {
        List<Goods> goods = new ArrayList<Goods>();
        String sql = "SELECT t_goods.goods_id,t_goods.name,t_goods.img_url,t_goods.price,t_goods.shop_name,t_goods.type,t_goods.flag,t_goods.create_time \n" +
                "from  t_like,t_goods,t_user\n" +
                "where t_like.goods_id=t_goods.goods_id AND t_like.user_id=t_user.id AND t_like.user_id=?\n" +
                "GROUP BY  t_like.goods_id order by count(t_like.goods_id) desc ,max(t_like.create_time) desc limit 0,10";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = C3p0ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Goods good = new Goods();
                good.setGoodsId(rs.getInt("goods_id"));
                good.setName(rs.getString("name"));
                good.setImgUrl(rs.getString("img_url"));
                good.setPrice(rs.getFloat("price"));
                good.setShopName(rs.getString("shop_name"));
                good.setType(rs.getString("type"));
                good.setFlag(rs.getInt("flag"));
                good.setCreateTime("create_time");
                goods.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3p0ConnectionFactory.closeDBResource(rs, pstmt, conn);
        }
        return goods;
    }

    /**
     * 根据用户id查询用户搜索历史记录
     *
     * @param userId
     * @return
     */
    public List<Goods> selectLikeGoodsByUserId2(int userId) {
        List<Goods> goods = new ArrayList<Goods>();
        String sql = "SELECT t_goods.goods_id,t_goods.name,t_goods.img_url,t_goods.price,t_goods.shop_name,t_goods.type,t_goods.flag,t_goods.create_time,t_like.create_time\n" +
                "from  t_like,t_goods,t_user\n" +
                "where t_like.goods_id=t_goods.goods_id AND t_like.user_id=t_user.id AND t_like.user_id=?\n" +
                "GROUP BY t_like.create_time desc limit 0,3";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = C3p0ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Goods good = new Goods();
                good.setGoodsId(rs.getInt("goods_id"));
                good.setName(rs.getString("name"));
                good.setImgUrl(rs.getString("img_url"));
                good.setPrice(rs.getFloat("price"));
                good.setShopName(rs.getString("shop_name"));
                good.setType(rs.getString("type"));
                good.setFlag(rs.getInt("flag"));
                good.setCreateTime(rs.getString("t_goods.create_time"));
                good.setHistory_time(rs.getString("t_like.create_time"));
                System.out.println("selectLikeGoodsByUserId2的Dao获到的数据：" + good);
                goods.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3p0ConnectionFactory.closeDBResource(rs, pstmt, conn);
        }
        return goods;
    }

    /**
     * 根据用户id，商品id以及浏览该商品的时间删除浏览记录
     *
     * @param userId
     * @param goodsId
     * @param createTime
     * @return
     */
    public int deleteLikeGoodsById(int userId, int goodsId, String createTime) {
        int ret = 0;
        String sql = "delete from t_like where user_id=? and goods_id=? and create_time=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = C3p0ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, goodsId);
            pstmt.setString(3, createTime);
            ret = pstmt.executeUpdate();
            System.out.println("ret" + ret + "userId" + userId + "goodsId" + goodsId + "createTime" + createTime);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3p0ConnectionFactory.closeDBResource(null, pstmt, conn);
        }
        return ret;
    }


    /**
     * 根据创建时间推荐商品
     * @return
     */
    public List<Goods> SelectBycreatetime(){
        List<Goods> list= new ArrayList<Goods>();
        String sql="select * from t_goods GROUP BY create_time DESC LIMIT 0,10";
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try{
            conn=C3p0ConnectionFactory.getConnection();
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while (rs.next()){
                Goods good = new Goods();
                good.setGoodsId(rs.getInt("goods_id"));
                good.setName(rs.getString("name"));
                good.setImgUrl(rs.getString("img_url"));
                good.setShopName(rs.getString("shop_name"));
                good.setPrice(rs.getFloat("price"));
                good.setType(rs.getString("type"));
                good.setCreateTime(rs.getString("create_time"));
                good.setFlag(rs.getInt("flag"));
                list.add(good);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3p0ConnectionFactory.closeDBResource(rs,pst,conn);
        }



        return  list;
    }

}
