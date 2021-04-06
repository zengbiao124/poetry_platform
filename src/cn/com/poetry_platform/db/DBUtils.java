package cn.com.poetry_platform.db;

import java.sql.*;

/**
 * 使用这个类来链接我们的Mysql数据库
 */
public class DBUtils {

    // 用户名。
    private static final String usernmame = "root";

    // 数据库的密码，自己是什么密码就改成什么密码。
    private static final String password = "zb123456";

    // 数据库的链接：连哪个数据库
    private static final String url = "jdbc:mysql://localhost:3306/poetry?serverTimezone=GMT%2B8&amp&useSSL=false&characterEncoding=utf-8";

    // 需要使用MySQL开发的jdbc驱动
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    /**
     * 获取MySQL的连接。
     *
     * @return
     */
    public static Connection getConnection() {

        Connection conn = null;
        try {
            // 获取链接。
            // 1、需要加载数据库的驱动
            Class.forName(driver);
            // 2、获取链接
            conn = DriverManager.getConnection(url, usernmame, password);
            DatabaseMetaData metaData = conn.getMetaData();
            //System.out.println("DatabaseProductVersion:"+ metaData.getDatabaseProductVersion()+";");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * 释放数据库得各种资源。
     *
     * @param rs
     * @param pstmt
     * @param conn
     */
    public static void closeDBResource(ResultSet rs, PreparedStatement pstmt, Connection conn) {

        try {
            // 先关闭ResultSet
            if(rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭PreparedStatement
                if(pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    // 关闭Connection
                    if(conn != null) {
                        conn.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        System.out.println(conn);
    }
}