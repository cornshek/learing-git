package collection;

import charactor.Hero;

import java.util.LinkedList;

/*
    链表结构：只连接前一个和后一个
    数组结构：每个位置都有表示，之间的间隔都是一样的
    LinkedList实现了
        双向链表 Deque  
        队列 queue    常用方法：offer peek poll
 */
public class LeranLinkedList {
    public static void testLinkedList() {
        LinkedList<Hero> ll = new LinkedList<>();
        ll.addLast(new Hero("1"));
        ll.addLast(new Hero("2"));
        ll.addLast(new Hero("3"));
        System.out.println(ll);

        ll.addFirst(new Hero("4"));
        ll.addFirst(new Hero("5"));
        ll.addFirst(new Hero("6"));
        System.out.println(ll);


        //queue的常用方法
        //offer poll peek
        ll.offer(new Hero("7"));
        ll.offer(new Hero("8"));
        ll.offer(new Hero("9"));
        ll.offer(new Hero("10"));
        System.out.println(ll);

        ll.poll();
        System.out.println(ll);
        System.out.println(ll.peek());

    }
}
