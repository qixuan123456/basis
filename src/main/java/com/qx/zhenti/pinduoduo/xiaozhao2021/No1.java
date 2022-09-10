package com.qx.zhenti.pinduoduo.xiaozhao2021;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/7/13 20:31
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        if(N>45) {
            System.out.println(-1);
        }

        int n = 1;
        long ans = 0;
        for (int i = 9; i >= 1&&N>0; i--) {
            ans+= (long) n *Math.min(i,N);
            n *=10;
            N -= i;
        }

        System.out.println(ans);
    }
}
