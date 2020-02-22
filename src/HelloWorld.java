import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
       for (int i = 0; i <= 14; i++){
           for (int j = 0; j <= 14; j++){
               for (int x = 0; x <= 14; x++){
                   for (int y = 0; y <= 14; y++){
                       if(i + j == 8 && x - y == 6 && i + x == 14 && j + y == 10)
                           System.out.println(i + "\n" + j + "\n" + x + "\n" + y);
                   }
               }
           }
       }
    }
}