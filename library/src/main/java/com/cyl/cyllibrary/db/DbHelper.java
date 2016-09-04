package com.cyl.cyllibrary.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 和sqlserver 建立连接
 * 用户获取数据库连接 （java web 中专用）
 *
 * @author cyl
 */
public class DbHelper {
    /**
     * 数据库名字
     */
    public final static String dataName = "ZW_Data_AppVideo";
    private static Connection connection;

    /**
     * 连接数据数据 库
     *
     * @param sUser 用户名
     * @param sPwd  数据库登录密码
     * @return
     */
    public Connection getcon(String sUser, String sPwd) {
        if (connection == null)
            try {
                String sDriverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                String sDBUrl = "jdbc:sqlserver://v.eeliu.com:1433;DatabaseName="
                        + dataName;

                Class.forName(sDriverName);
                connection = DriverManager.getConnection(sDBUrl, sUser, sPwd);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        return connection;
    }
}
