package jdbc;

import java.sql.*;

public class LearnCRUD {
    public static void insert() {
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //准备PreparedStatement的SQL语句
        String sql = "insert into hero values(null,?,?,?)";
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java" +
                                "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8",
                        "root", "12345677");
                Statement s = c.createStatement();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            //用Statement和PrepareStatement分别插入一万条数据，计算消耗的时间
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                String sql01 = String.format("insert into hero values(null,'hero%d',null,null)", i);
                s.execute(sql01);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Statement插入消耗的时间为：" + (endTime - startTime) + "ms");

            startTime = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                ps.setString(1, "hero" + i);
                ps.setNull(2,Types.FLOAT);
                ps.setNull(3,Types.INTEGER);
                ps.execute();
            }
            endTime = System.currentTimeMillis();
            System.out.println("PreparedStatement插入消耗的时间为：" + (endTime - startTime) + "ms");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //判断账号密码是否正确
    public static void queryPassword() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                //try with resource 的方式，自动关闭连接
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java" +
                                "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8",
                        "root", "12345677");
                Statement s = c.createStatement();
        ) {
            String name = "shek";
            //正确密码：password
            String password = "password";

            //准备查询语句
            String sql = String.format("select * from user where name = '%s' and password = '%s'"
                    , name, password);

            //执行查询语句，并把结果返回给ResultSet
            ResultSet rs = s.executeQuery(sql);

            //如果有结果，则密码正确，否则不正确
            if (rs.next()) {
                System.out.println("正确");
            } else {
                System.out.println("错误");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //获取总数
    public static void queryTotal() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                //try with resource 的方式，自动关闭连接
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java" +
                                "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8",
                        "root", "12345677");
                Statement s = c.createStatement();
        ) {

            //准备查询语句
            String sql = String.format("select count(*) from hero");

            //执行查询语句，并把结果返回给ResultSet
            ResultSet rs = s.executeQuery(sql);
            int total = 0;
            while (rs.next()) {
                total = rs.getInt(1);
            }
            System.out.println(total);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //分页查询，page为查询的页码(查询第几页)，count为每页显示的数目
    public static void pagedQuery(int page, int count) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                //try with resource 的方式，自动关闭连接
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java" +
                                "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8",
                        "root", "12345677");
                Statement s = c.createStatement();
        ) {

            //将传进来的参数page转换为startCount

            int startCount = (page - 1) * count;

            //准备查询语句
            String sql = String.format("select * from hero limit %d,%d", startCount, count);

            //执行查询语句，并把结果返回给ResultSet
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.printf("%d\t%s\n", id, name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
