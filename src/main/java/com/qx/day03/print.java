package com.qx.day03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class print {


    public static void a(){
        FileReader fr = null;

        byte[] buff = new byte[8];
        char[] c = new char[8];
        int len;
        try {
            fr= new FileReader("src/banner.txt");
            while((len=fr.read(c))!= -1)
            {

                System.out.print(new String(c,0,len));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
