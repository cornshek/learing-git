package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
    向数据库中插入100条数据，比较传统方式和数据库连接池方式的性能差异
    1. 使用传统方式创建100个线程，每个线程都会创建新的连接，通过这个连接向数据库插入1条数据，然后关闭这个连接。
    2. 使用数据库连接池的方式，创建一个有10条连接的连接池，然后创建100个线程，每个线程都会向连接池借用连接，借用到后，向数据库插入1条数据，然后归还这个连接。
    通过时间统计，比较这两种方式的性能表现差异。
 */
public class TestConnectionPool {
    //加载驱动
    public static void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //传统方式
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java" +
                        "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8",
                "root", "12345677");
    }

    public static void connectionByTradition() {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            final int x = i;
            Thread t = new Thread() {
                String sql = "insert into hero values(null,?,?,?)";

                @Override
                public void run() {
                    try (
                            Connection c = getConnection();
                            PreparedStatement ps = c.prepareStatement(sql);
                    ) {
                        ps.setString(1, "传统hero" + x);
                        ps.setNull(2, Types.FLOAT);
                        ps.setNull(3, Types.INTEGER);
                        System.out.println(this.getName() + "正在插入数据");
                        ps.execute();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.setName("传统方式线程" + i);
            t.start();
            threads.add(t);

        }

        //等待全部线程执行完毕
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //连接池方式
    public static void connectionByPool(ConnectionPool connectionPool) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            final int x = i;
            Thread t = new Thread() {
                String sql = "insert into hero values(null,?,?,?)";

                @Override
                public void run() {
                    Connection c = connectionPool.getConnection();
                    try (
                            PreparedStatement ps = c.prepareStatement(sql);

                    ) {
                        ps.setString(1, "连接池hero" + x);
                        ps.setNull(2, Types.FLOAT);
                        ps.setNull(3, Types.INTEGER);
                        System.out.println(this.getName() + "正在插入数据");
                        ps.execute();
                        connectionPool.returnConnection(c);

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.setName("连接池线程" + i);
            t.start();

            threads.add(t);
        }

        //等待所有连接池线程执行完毕
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
