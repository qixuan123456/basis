package com.qx.yinhang;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Test01 {

    public static void main(String[] args) throws Exception {
          ZhangHu zhangHu = new ZhangHu("411324199807071933","111",0);
          Account account = new Account("齐旋",22,zhangHu);
         aa.updateStartBat("src/Day01/account","411324199807011933 111 80000","411324199807011933 111 87000");

    }
}
class aa{
public static Boolean updateStartBat(String fileName, String oldstr, String newStr){
        RandomAccessFile raf = null;
        try {
        raf = new RandomAccessFile("src/Day01/account", "rw");
        String line = null;
        long lastPoint = 0; //记住上一次的偏移量
        while ((line = raf.readLine()) != null) {
final long ponit = raf.getFilePointer();
        if(line.contains(oldstr)){
        String str=line.replace(oldstr, newStr);
        raf.seek(lastPoint);
        raf.writeBytes(str);
        }
        lastPoint = ponit;
        }
        } catch (FileNotFoundException e) {

        e.printStackTrace();
        } catch (IOException e) {

        e.printStackTrace();
        } finally {
        try {
        raf.close();
        } catch (IOException e) {
        e.printStackTrace();
        }
        }
        return true;
        }
        }