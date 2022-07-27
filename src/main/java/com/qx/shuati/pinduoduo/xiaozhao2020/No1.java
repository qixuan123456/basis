package com.qx.shuati.pinduoduo.xiaozhao2020;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/7/6 20:31
 */
public class No1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            System.out.println(get(n));
        }
    }
    public static int get(int n){
        int res = 0;
        while (n>0){
            n = n>>1;
            res++;
        }
        return res;
    }
}
