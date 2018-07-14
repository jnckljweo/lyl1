package com.company;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDome {
    private void testConnection() {
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建数据库连接字符串
            String dbURL = "jdbc:mysql://127.0.0.1:3306/test";

            //建立数据库连接
            try {
                Connection connection =  DriverManager.getConnection(dbURL,"root","lyl0813");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String  args[]){
        JDBCDome jdbcDome= new JDBCDome();
        jdbcDome.testConnection();
    }
}