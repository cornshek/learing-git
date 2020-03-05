package jdbc.dao;

import charactor.Hero;

import java.util.List;

public interface DAO {

    //插入
    public void add(Hero hero);

    //修改
    public void update(Hero hero);

    //删除
    public void delete(int id);

    //获取
    public Hero get(int id);

    //查询
    public List<Hero> list();

    //分页查询
    public List<Hero> list(int start, int count);
}
