package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AutoCreate {
    public static void run() {
        Scanner s = new Scanner(System.in);
        //创建文件对象f_template，创建字符流FileReader 缓存流BufferReader
        File f_template = new File("D:\\flie\\Project\\idea\\j2se\\src\\io\\Template.txt");
        try (
                FileReader fr = new FileReader(f_template);
                BufferedReader br = new BufferedReader(fr);
        ) {
            //读取模板文件tamplate.txt，存放于StringBuffer中
            String line_template = null;
            StringBuffer all_template = new StringBuffer();
            while ((line_template = br.readLine()) != null) {
//                System.out.println(line_template);
                all_template.append(line_template+"\n");
            }
            System.out.println(all_template);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //从控制台获取所需参数
        //我要试试添加提交信息
        //我再试试提交信息
        System.out.println("请输入类的名称");
        String classname = s.nextLine();
        System.out.println("请输入属性的类型");
        String property_type = s.nextLine();
        System.out.println("请输入属性的名称");
        String property_name = s.nextLine();

        //
    }
}
