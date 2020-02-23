package io;

import charactor.Hero;

import java.io.*;

public class ArrayObjectStream {
    public static void arrayStream(){
        //创建Hero数组并初始化
        Hero[] heroes = new Hero[10];
        for (int i = 0; i < 10; i++) {
            heroes[i] = new Hero("temp0"+i,i+100);
        }

        //打印heroes数组，检查初始化是否正确
//        for (Hero h : heroes) {
//            System.out.println(h.toString());
//        }

        //准备一个文件用于存放序列化数组
        File f = new File("C:\\Users\\lenovo\\Desktop\\j2se.txt");
        try (
                //创建对象输入输出流
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);

        ) {
            //序列化数组heroes，并放入j2se.txt
            oos.writeObject(heroes);
            //反序列化j2se.txt，转化为Hero数组，检查与序列化前时候一样
            Hero[] heroes1 = (Hero[])ois.readObject();
            for (Hero h : heroes1) {
                System.out.println(h.toString());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
