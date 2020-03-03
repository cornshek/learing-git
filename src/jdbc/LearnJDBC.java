package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LearnJDBC {
    public static void run() {
        try {
            //初始化驱动
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库驱动加载成功");

            //建立与数据库的连接
            //提供：
            //数据库所处于的ip
            //数据库的端口号
            //数据库名称
            //编码方式
            //账号
            //密码

            Connection c = DriverManager
                    .getConnection(
                            "jdbc:mysql://127.0.0.1:3306/how2java" +
                                    "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8",
                            "root", "12345677");
            System.out.println("连接成功，获取连接对象：" + c);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
