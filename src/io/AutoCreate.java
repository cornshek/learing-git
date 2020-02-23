package io;

import java.io.*;
import java.util.Scanner;

public class AutoCreate {
    public static void run() {
        Scanner s = new Scanner(System.in);
        //创建文件对象f_template
        File fTemplate = new File("D:\\flie\\Project\\idea\\j2se\\src\\io\\Template.txt");

        //创建String用于读取及存放模板内容
        String sTemplate = null;

        try (
                //创建字符输入流，读取模板Template.txt
                FileReader fr = new FileReader(fTemplate);
        ) {
            //读取模板文件template.txt，存放于字符数组中，再将字符数组转换为String
            char[] cTemplate = new char[(int) fTemplate.length()];
            fr.read(cTemplate);
            sTemplate = new String(cTemplate);
//            System.out.println(template);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //从控制台获取所需参数
        System.out.println("请输入类的名称");
        String className = s.nextLine();
        System.out.println("请输入属性的类型");
        String propertyType = s.nextLine();
        System.out.println("请输入属性的名称");
        String propertyName = s.nextLine();

        //将模板中的参数替换为从控制台获取的参数
        String fileContent = sTemplate.replaceAll("@class@", className);
        fileContent = fileContent.replaceAll("@type@", propertyType);
        fileContent = fileContent.replaceAll("@property@", propertyName);
        fileContent = fileContent.replaceAll("@Uproperty@", propertyName);
        //准备使用的文件名
        String fileName = className + ".java";
        System.out.println("文件的内容：");
        System.out.println(fileContent);

        //写入文件
        File fSave = new File("D:\\flie\\Project\\idea\\j2se\\src\\io",fileName);
        try (
                //创建字符输出流
                FileWriter fw = new FileWriter(fSave)
        ) {
            fw.write(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件保存在：" + fSave.getAbsolutePath());
    }
}
