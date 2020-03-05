package jdbc;

import charactor.Hero;

import java.sql.*;

public class LearnORM {
    public static Hero get(int id) {
        Hero hero = null;
        //加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //准备PreparedStatement使用的sql语句
        String sql = "select * from hero where id = ?";

        //try with resource
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java" +
                                "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8",
                        "root", "12345677");
                PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hero = new Hero();
                hero.setName(rs.getString("name"));
                hero.setHp(rs.getFloat("hp"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }

    //TODO add Hero对象
    public static void add(Hero hero) {

    }

    //TODO delete Hero对象

    //TODO update Hero对象

    //TODO 查询所有Hero数据，在一个List<Hero>中返回

}
