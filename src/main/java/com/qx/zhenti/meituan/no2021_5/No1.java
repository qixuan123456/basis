package com.qx.zhenti.meituan.no2021_5;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/14 15:12
 */
public class No1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if(Character.isUpperCase(s.charAt(i))){
                num++;
            }
        }
        System.out.println(Math.abs(s.length()/2-num));
    }
}
