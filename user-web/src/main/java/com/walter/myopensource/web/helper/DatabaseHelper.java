package com.walter.myopensource.web.helper;

import com.walter.myframework.utils.PropsUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * Created by wangdongliang on 16/4/7.
 */
public final class DatabaseHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseHelper.class);

    private static final String JDBC_DRIVER;
    private static final String JDBC_URL;
    private static final String JDBC_USERNAME;
    private static final String JDBC_PASSWORD;

    static {
        Properties properties = PropsUtil.loadProps("config.properties");
        JDBC_DRIVER = properties.getProperty("jdbc.driver");
        JDBC_URL = properties.getProperty("jdbc.url");
        JDBC_USERNAME = properties.getProperty("jdbc.username");
        JDBC_PASSWORD = properties.getProperty("jdbc.password");

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error("jdbc driver load failed with error: " + e);
        }
    }

    private static final QueryRunner QUERY_RUNNER = new QueryRunner();

    //diamond grammer in java8
    private static final ThreadLocal<Connection> CONNECTION_THREAD_LOCAL = new ThreadLocal<>();

    public static <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params){
        List<T> entityList;

        try{
            Connection conn = getConnection();
            entityList = QUERY_RUNNER.query(conn, sql, new BeanListHandler<T>(entityClass), params);
        }catch (SQLException e){
            LOGGER.error("");
            throw new RuntimeException(""+e);
        }finally {
            closeConnection();
        }

        return entityList;
    }

    public static Connection getConnection(){
        Connection conn = CONNECTION_THREAD_LOCAL.get();
        if (conn == null){
            try {
                conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }finally {
                CONNECTION_THREAD_LOCAL.set(conn);
            }
        }
        return conn;
    }

    public static void closeConnection(){
        Connection conn = CONNECTION_THREAD_LOCAL.get();
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                CONNECTION_THREAD_LOCAL.remove();
            }
        }
    }

}
