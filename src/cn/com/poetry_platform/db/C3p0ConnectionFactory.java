package cn.com.poetry_platform.db;

import cn.com.poetry_platform.utils.ConfigFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * C3P0获取数据库连接。
 *
 * @author sinoyang
 */
public final class C3p0ConnectionFactory {

    private static ComboPooledDataSource cpds = new ComboPooledDataSource(true);

    static {
        try {
            cpds.setDataSourceName("MySQLC3p0DataSource");
            cpds.setJdbcUrl(ConfigFactory.getString("mysql.url"));
            cpds.setDriverClass(ConfigFactory.getString("mysql.driver"));
            cpds.setUser(ConfigFactory.getString("mysql.username"));
            cpds.setPassword(ConfigFactory.getString("mysql.password"));
            ///////////////////////////////
            cpds.setInitialPoolSize(5);
            cpds.setMaxPoolSize(10);
            cpds.setMinPoolSize(5);
            cpds.setCheckoutTimeout(5000);
            cpds.setAcquireIncrement(50);
            cpds.setMaxIdleTime(240);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库链接。
     * @return
     */
    public static Connection getConnection() {
        try {
            return cpds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭各种数据库资源。
     *
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void closeDBResource(ResultSet rs, Statement stmt, Connection conn) {

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        for(int i=0;i<11; i++) {
            Connection conn = getConnection();
            System.out.println(conn);
        }
	}
}