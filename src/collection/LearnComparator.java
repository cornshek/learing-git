package collection;

import charactor.Hero;

import java.util.*;

public class LearnComparator {
    public static void run() {
        //准备一个ArrayList<Hero> heroes存放Hero对象
        List<Hero> heroes = new ArrayList<>();

        //通过随机值实例化hero的hp和armor
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            heroes.add(new Hero(random.nextInt(1000), random.nextInt(500)));
        }
        System.out.println(heroes);

        //引入Comparator 指定比较的算法
        //或使Hero类实现Comparable接口，在类里面提供比较算法，就无需提供Comparator
//        Comparator<Hero> c = new Comparator<Hero>() {
//            @Override
//            public int compare(Hero o1, Hero o2) {
//                //按照hp排序
//                if (o1.getHp() >= o2.getHp()) {
//                    //正数表示o1>=o2
//                    return 1;
//                } else {
//                    return -1;
//                }
//            }
//        };
        Collections.sort(heroes);
        System.out.println(heroes);

    }
}
