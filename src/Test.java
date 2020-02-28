import charactor.Hero;
import collection.LearnArrayList;
import collection.LeranLinkedList;
import collection.binarytree.HeroNode;
import collection.binarytree.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        List<Hero> heroes = new ArrayList<>();

        //用Random类的nextInt方法生成随机数，作为参数生成随机的Hero对象
        for (int i = 0; i < 10; i++) {
            heroes.add(new Hero("hero" + i, random.nextInt(1000)));
        }
        for (Hero h : heroes) {
            System.out.println(h);
        }


        //将随机生成的Hero数组插入二叉树中
        Node rootNode = new Node();
        HeroNode rootHeroNode = new HeroNode();
        for (Hero h : heroes) {
            rootHeroNode.add(h);
        }
//
//        //遍历二叉树，升序排列应使用中序遍历
        System.out.println(rootHeroNode.inorderTraversal());
    }
}
