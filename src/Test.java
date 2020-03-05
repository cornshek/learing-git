import charactor.Hero;
import jdbc.ConnectionPool;
import jdbc.LearnCRUD;
import jdbc.LearnORM;
import jdbc.TestConnectionPool;
import jdbc.dao.HeroDAO;

public class Test {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        TestConnectionPool.connectionByTradition();
        long endTime = System.currentTimeMillis();
        long Time01 = endTime - startTime;

        startTime = System.currentTimeMillis();
        ConnectionPool connectionPool = new ConnectionPool(20);
        TestConnectionPool.connectionByPool(connectionPool);
        endTime = System.currentTimeMillis();
        long Time02 = endTime - startTime;
        System.out.println(Time01);
        System.out.println(Time02);
    }

}
