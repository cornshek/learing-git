package io;

import charactor.Hero;

import java.io.*;

public class ObjectStream {
    public static void objectIOStream(){
        Hero h = new Hero();
        h.setName("garen");
        h.setHp(616);

        //准备一个文件用于保存对象
        File f = new File("C:\\Users\\lenovo\\Desktop\\j2se.txt");
        try (
                //创建对象输出流
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                //创建对象输入流
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            oos.writeObject(h);
            Hero h2 = (Hero) ois.readObject();
            System.out.println(h2.getName());
            System.out.println(h2.getHp());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
