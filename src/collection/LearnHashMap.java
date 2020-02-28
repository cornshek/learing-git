package collection;

/*
    准备一个ArrayList其中存放3000000(三百万个)Hero对象，其名称是随机的,格式是hero-[4位随机数]
hero-3229
hero-6232
hero-9365
...

因为总数很大，所以几乎每种都有重复，把名字叫做 hero-5555的所有对象找出来
要求使用两种办法来寻找
1. 不使用HashMap，直接使用for循环找出来，并统计花费的时间
2. 借助HashMap，找出结果，并统计花费的时间
 */

import charactor.Hero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LearnHashMap {
    public static void run() {
        //按照格式随机生成300,0000个Hero对象，存放于ArrayList中
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 3000000; i++) {
            heroes.add(new Hero("hero-" + (int) (Math.random() * 10000)));
        }

        //创建HashMap对象
        HashMap<String, ArrayList<Hero>> heroHashMap = new HashMap<>();
        //遍历heroes集合于h，将h.getName相等的对象存放于同一个ArrayList<Hero>中
        //以key-value(h.getName-ArrayList<Hero>)形式保存每个ArrayList<Hero>于heroHashMap中
        for (Hero h : heroes) {
            //用key(h.getName)获取value(ArrayList<Hero>)
            ArrayList<Hero> value = heroHashMap.get(h.getName());
            //如果用当前key获取的value(ArrayList<Hero>)为空，创建一个，放入heroHashMap中
            if (null == value) {
                value = new ArrayList<Hero>();
                heroHashMap.put(h.getName(), value);
            }
            value.add(h);
        }
        long startTime = System.currentTimeMillis();
        System.out.println(heroHashMap.get("hero-5555").size());
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }

}
