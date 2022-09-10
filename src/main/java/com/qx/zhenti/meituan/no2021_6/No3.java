package com.qx.zhenti.meituan.no2021_6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/15 21:14
 */
public class No3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] strings = new String[n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }
        while(n%2==0){
            if(check(strings,n)){
                n = n/2;
            }else {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(strings[i]);
        }

    }

    public static boolean check(String[] strings ,int n){
        for (int i = 0; i < n / 2; i++) {
            if(!strings[i].equals(strings[n-1-i])){
                return false;
            }
        }
        return true;
    }
}
