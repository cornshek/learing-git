import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //File实例 j2se.txt
        File f = new File("C:\\Users\\lenovo\\Desktop\\j2se.txt");

        try(
                //创建基于文件的字符流
                FileWriter fw = new FileWriter(f);
                // 缓存字符输出流 PrintWriter
                PrintWriter pw = new PrintWriter(fw);
        ){
            pw.println("哈哈哈");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
