package collection;

import charactor.Hero;
import property.Item;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

/*
使用ArrayList一般用List声明：List list = new ArrayList();
方便重构代码，面向接口编程的好处
 */
public class LearnArrayList {
    public static void testArrayList() {
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            heroes.add(new Hero("forTest" + i));
        }

        //创建一个List 存放即将删除的对象
        List<Hero> heroesToDelete = new ArrayList<>();

        //for循环遍历List，将编号名称为8的倍数的对象放入heroesToDelete中
        for (int i = 0; i < heroes.size(); i++) {
            Hero h = heroes.get(i);
//            System.out.println(h);
            if (0 == i % 8 && i != 0) {
                heroesToDelete.add(h);
            }
        }

        //删除
        heroes.removeAll(heroesToDelete);


        //增强型for循环遍历List
        //方便 首选
//        for (Hero h : heroes) {
//            System.out.println(h);
//        }

        //迭代器遍历List
        Iterator<Hero> it = heroes.iterator();
//        while (it.hasNext()) {
//            Hero h = it.next();
//            System.out.println(h);
//        }

        //迭代器for写法
        for (; it.hasNext(); ) {
            Hero h = it.next();
            System.out.println(h);
        }
    }
}
