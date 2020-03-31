package com.xuesong.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author : Snow
 * @date : 2020/3/31
 */
public class JDBCUtils {
    private static DataSource dataSource;

    //通过静态代码块加载配置文件，初始化连接池对象
    static {
        //加载Properties配置文件
        Properties properties = new Properties();
        try {
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 获取连接池的方法
     * @Param: []
     * @return: javax.sql.DataSource
     * @Author: Snow
     * @Date: 2020/3/31
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //释放资源
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void close(Statement statement, Connection connection) {
        close(null, statement, connection);
    }
}
