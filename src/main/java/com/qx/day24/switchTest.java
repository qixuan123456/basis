package com.qx.day24;

import java.util.Random;

public class switchTest {
    public static void main(String[] args) {
        int a = new Random().nextInt(5);
        System.out.println(a);
        switch (a){
            case 1:
            case 2:
            case 3:
            case 4:
                System.out.println(4);break;
            default:
                System.out.println("其他");break;
        }
        if((a&1)==1){
            System.out.println();
        }
    }
}
