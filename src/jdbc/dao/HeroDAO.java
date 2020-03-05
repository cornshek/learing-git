package jdbc.dao;

import charactor.Hero;

import java.sql.*;
import java.util.List;

public class HeroDAO implements DAO {
    //驱动初始化放在构造方法中
    public HeroDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //提供getConnection 返回连接
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java" +
                        "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8",
                "root", "12345677");
    }

    public int getTotal() {
        int total = 0;
        String sql = "select count(*) from hero";
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public void add(Hero hero) {
        String sql = "insert into hero values(null,?,?,?)";
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, hero.getName());
            ps.setFloat(2, hero.getHp());
            ps.setNull(3, Types.INTEGER);
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                hero.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Hero hero) {

        String sql = "update hero set name = ?, hp = ?, where id = ?";
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, hero.getName());
            ps.setFloat(2, hero.getHp());
            ps.setInt(3, hero.getId());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        String sql = "delete from hero where id = ?";
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)
        ) {
            ps.setInt(1,id);
            ps.execute();

            System.out.println("执行删除语句成功");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Hero get(int id) {
        Hero hero = null;
        String sql = "select * from hero where id = ?";
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
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

    @Override
    public List<Hero> list() {
        return null;
    }

    @Override
    public List<Hero> list(int start, int count) {
        return null;
    }
}
