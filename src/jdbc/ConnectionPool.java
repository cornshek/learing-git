package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    //准备容器存放提前创建好的连接
    private List<Connection> connections = new ArrayList<>();

    private int size;

    public ConnectionPool(int size) {
        this.size = size;
        this.init();
    }

    //初始化方法init()
    public void init() {
        //不能使用try with resource方式，需要保持连接不关闭

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            for (int i = 0; i < this.size; i++) {
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java" +
                                "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8",
                        "root", "12345677");
                connections.add(c);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //从Pool中获取其连接
    public synchronized Connection getConnection() {
        while (this.connections.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Connection c = this.connections.remove(0);
        return c;
    }

    //将连接归还到pool
    public synchronized void returnConnection(Connection c) {
        this.connections.add(c);
        this.notifyAll();
    }
}
