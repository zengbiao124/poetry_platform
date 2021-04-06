package cn.com.poetry_platform.dao;

import cn.com.poetry_platform.db.C3p0ConnectionFactory;
import cn.com.poetry_platform.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用户数据访问层
 */
public class UserDao {

    private Logger logger = LoggerFactory.getLogger(UserDao.class);

    public void selectUserByUsernamePassword(String username, String password) {
        logger.trace("UserDao.selectUserByUsernamePassword() username=" + username + ", password=" + password);
        logger.debug("UserDao.selectUserByUsernamePassword() username=" + username + ", password=" + password);
        logger.info("UserDao.selectUserByUsernamePassword() username=" + username + ", password=" + password);
        logger.warn("UserDao.selectUserByUsernamePassword() username=" + username + ", password=" + password);
        logger.error("UserDao.selectUserByUsernamePassword() username=" + username + ", password=" + password);
    }

    /**
     * 根据ID查询用户。
     *
     * @param id
     * @return
     */
    public User selectUserById(int id) {

        User user = null;
        String sql = "SELECT id, username,email, password, flag FROM t_user WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = C3p0ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(sql);
            // 设置参数
            pstmt.setInt(1, id);
            // 查询
            rs = pstmt.executeQuery();
            // 循环迭代
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFlag(rs.getInt("flag"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectUserById()" + e.getMessage());
        } finally {
            // 关闭资源
            C3p0ConnectionFactory.closeDBResource(rs, pstmt, conn);
        }
        return user;
    }

    /**
     * 通过用户名、密码查询用户信息，用于登录。
     *
     * @param username
     * @param password
     * @return
     */
    public User selectUserByUsernameAndPassword(String username, String password) {

        String sql = "SELECT id, username, email,password, flag FROM t_user WHERE username = ? AND password = ?";
        User user = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = C3p0ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(sql);
            // 设置参数
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            // 查询
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFlag(rs.getInt("flag"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("selectUserByUsernameAndPassword()" + e.getMessage());
        } finally {
            C3p0ConnectionFactory.closeDBResource(rs, pstmt, conn);
        }

        return user;
    }

    /**
     * 插入一个普通用户。
     *
     * @param user
     * @return
     */
    public int insertUser(User user) {

        int ret = 0;
        String sql = "INSERT INTO t_user(username,email, password, flag) VALUES (?, ?, ?, 0)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = C3p0ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2,user.getEmail());
            pstmt.setString(3, user.getPassword());
            ret = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("insertUser()" + e.getMessage());
        } finally {
            C3p0ConnectionFactory.closeDBResource(null, pstmt, conn);
        }

        return ret;
    }

    /**
     * 插入一个管理员用户
     *
     * @param user
     * @return
     */
    public int insertManagerUser(User user) {

        int ret = 0;
        String sql = "INSERT INTO t_user(username, password,email,flag) VALUES (?, ?, ?,1)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = C3p0ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2,user.getEmail());
            pstmt.setString(3, user.getPassword());
            ret = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("insertManagerUser()" + e.getMessage());
        } finally {
            C3p0ConnectionFactory.closeDBResource(null, pstmt, conn);
        }

        return ret;
    }


    /**
     * 通过用户名查询用户信息。
     *
     * @param username
     * @return
     */
    public User selectByUsername(String username) {

        String sql = "SELECT id, username,email, password, flag FROM t_user WHERE username = ?";
        User user = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = C3p0ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(sql);
            // 设置参数
            pstmt.setString(1, username);
            // 查询
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFlag(rs.getInt("flag"));
            }
        } catch (Exception e) {
            logger.error("selectByUsername()" + e.getMessage());
            e.printStackTrace();
        } finally {
            C3p0ConnectionFactory.closeDBResource(rs, pstmt, conn);
        }

        return user;
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    public int updateUser(User user) {
        int ret = 0;
        String sql = "UPDATA t_user SET username =?,email=?, password =?, flag =? WHERE id =?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = C3p0ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(sql);

            //设置参数
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2,user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setInt(4, user.getFlag());
            pstmt.setInt(6, user.getId());
            ret = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            C3p0ConnectionFactory.closeDBResource(null, pstmt, conn);
        }
        return ret;
    }

    /**
     * 通过用户名设置密码
     * @param username
     * @param password
     * @return
     */
    public int updateUserByName(String username, String password) {
        int ret = 0;
        String sql = "UPDATE t_user SET `password` =? WHERE username = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = C3p0ConnectionFactory.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, password);
            pstmt.setString(2, username);
            ret = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3p0ConnectionFactory.closeDBResource(null, pstmt, conn);
        }
        return ret;
    }
}