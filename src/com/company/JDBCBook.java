package com.company;

import java.sql.*;
import java.util.Scanner;

public class JDBCBook {
    private Connection getConnection() {
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建数据库连接字符串
            String dbURL = "jdbc:mysql://127.0.0.1:3306/t2";

            //建立数据库连接
            try {
                Connection connection = DriverManager.getConnection(dbURL, "root", "lyl0813");
                return connection;  //返回连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    //封装释放数据库连接操作     释放连接——最后用的最先释放
    private void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    //添加数据
    private void insertDate(int id, String book_name, String book_publishers, String book_author,String creat_date) {
        //创建数据库连接
        Connection connection = getConnection();
        Statement statement = null;
        try {
            //构建添加数据的sql语句
            String sql = "insert into book values('" + id + "','" + book_name + "','" + book_publishers + "','" + book_author + "','" + creat_date + "')";
            // 执行sql语句
            statement = connection.createStatement();
            int rows = (statement).executeUpdate(sql);
            System.out.println("所受影响的行数：" + rows);
            //得到执行后的结果，确定是否添加成功
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close(connection, statement, null);
        }
    }

    //修改数据
    private void upDate(int id, String book_name, String book_publishers, String book_author,String creat_date) {
        //创建数据库连接
        Connection connection = getConnection();
        Statement statement = null;
        try {
            //构建修改数据的sql语句
            String sql = "update book set " + "book_name='" + book_name + "',book_publishers='" + book_publishers + "',book_author='" + book_author + "',creat_time='"+ creat_date+"where id=" + id + "";
            // 执行sql语句
            statement = connection.createStatement();
            int rows = (statement).executeUpdate(sql);
            System.out.println("更新结果为：" + (rows > 0));
            //得到执行后的结果，确定是否修改成功
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close(connection, statement, null);
        }
    }

    //删除数据
    private void deleteDate(int id) {
        //创建数据库连接
        Connection connection = getConnection();
        Statement statement = null;
        try {
            //构建删除数据的sql语句
            String sql = "delete from book where id=" + id + "";
            // 执行sql语句
            statement = connection.createStatement();
            int rows = (statement).executeUpdate(sql);
            System.out.println("有" + rows + "被删除成功");
            //得到执行后的结果，确定是否删除成功
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close(connection, statement, null);
        }
    }

    //查询所有数据
    private void findAllDate() {
        //获取数据库连接
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        //构建查询的sql语句
        String sql = "select * from book";
        //执行sql语句并获得结果集
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            StringBuffer buffer = new StringBuffer();
            buffer.append("-------------------------------------------------------------------------------------------------------" + System.lineSeparator());
            buffer.append("id\t\t\t\tbook_name\t\t\t\tbook_publishers\t\t\t\tbook_author\t\t\t\tcreate_time" + System.lineSeparator());
            buffer.append("-------------------------------------------------------------------------------------------------------" + System.lineSeparator());
            //建立结果集，输出每条结果的信息
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String book_name = resultSet.getString("book_name");
                String book_publishers = resultSet.getString("book_publishers");
                String book_author = resultSet.getString("book_author");
                String create_time = resultSet.getString("create_time");
                buffer.append(id + "\t\t\t|" + book_name + "\t\t\t\t|" + book_publishers + "\t\t\t\t|" + book_author + "\t\t\t\t|" + create_time + "\t\t\t\t|" + System.lineSeparator());
            }
            System.out.println(buffer.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close(connection, statement, resultSet);
        }
    }

    //根据用户输入的关键字来模糊查找
    private void findKeyword(String keyword) {
        //获取数据库连接
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        //构建查询的sql语句
        String sql = "select book_name,book_publishers,book_author from book where book_name like '%" + keyword + "%' or book_publishers like'%" + keyword + "%' or book_author like '%" + keyword + "%'";
        //执行sql语句并获得结果集
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            StringBuffer buffer = new StringBuffer();
            buffer.append("-------------------------------------------------------------------------------------------" + System.lineSeparator());
            buffer.append("id\t\t\t\tbook_name\t\t\t\tbook_publishers\t\t\t\tbook_author\t\t\t\tcreate_time" + System.lineSeparator());
            buffer.append("-------------------------------------------------------------------------------------------" + System.lineSeparator());
            //建立结果集，输出每条结果的信息
            while (resultSet.next()) {
                String book_name = resultSet.getString("book_name");
                String book_publishers = resultSet.getString("book_publishers");
                String book_author = resultSet.getString("book_author");
                buffer.append( "\t\t\t|" + book_name + "\t\t\t\t|" + book_publishers + "\t\t\t\t|" + book_author +  "\t\t\t\t" + System.lineSeparator());
            }
            System.out.println(buffer.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close(connection, statement, resultSet);
        }
    }

    public static void main(String args[]) {
        JDBCBook jdbcBook = new JDBCBook();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=======================================");
            System.out.println("       欢迎使用图书管理系统      ");
            System.out.println("1、添加书籍信息");
            System.out.println("2、修改书籍信息");
            System.out.println("3、删除书籍信息");
            System.out.println("4、查询所有书籍");
            System.out.println("5、按关键字查询书籍");
            System.out.println("6、退出系统");
            System.out.println("=======================================");
            System.out.println("请选择你要进行的操作：");
            int select = 0;  //接受用户选择的选项
            select = scanner.nextInt();
            while (select < 1 || select > 7) {
                System.out.println("选择的操作不能识别，请重新选择！");
                select = scanner.nextInt();
            }
            String value = null;
            if (select == 1) {//添加数据
                System.out.println("请输入你要添加的id、书籍名字、出版商、作者和创建日期，中间用逗号分隔");
                value = scanner.next();
                String[] values = value.split(",");
                jdbcBook.insertDate(Integer.parseInt(values[0]), values[1], values[2], values[3],values[4]);
            } else if (select == 2) {//修改数据
                System.out.println("请输入你要修改的id、书籍名字、出版社、作者和创建日期，中间用逗号分隔");
                value = scanner.next();
                String[] values = value.split(",");
                jdbcBook.upDate(Integer.parseInt(values[0]), values[1], values[2], values[3],values[4]);
            } else if (select == 3) {//删除数据
                System.out.println("请输入你要删除的id");
                value = scanner.next();
                jdbcBook.deleteDate(Integer.parseInt(value));
            } else if (select == 4) {//查询所有数据
                jdbcBook.findAllDate();
            } else if (select == 5) {//模糊查询
                System.out.println("请输入你想要查询的关键字：");
                value = scanner.next();
                jdbcBook.findKeyword(value);
            } else if (select == 6) {//退出系统
                System.exit(-1);
            }
        }
    }
}

