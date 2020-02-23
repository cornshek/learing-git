package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CharStream {
    public static void readForChar() {
        File f = new File("C:\\Users\\lenovo\\Desktop\\j2se.txt");
        try (FileReader fr = new FileReader(f)) {
            char[] all = new char[(int)f.length()];
            fr.read(all);
            for (char a : all) {
                System.out.println(a);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
