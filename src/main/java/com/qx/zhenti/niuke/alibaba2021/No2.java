package com.qx.zhenti.niuke.alibaba2021;

import java.util.Scanner;

/**
 * @author Xuan
 * Date: 2022/4/13
 * Time: 12:51
 */
public class No2 {
    public static void main(String[] args) {
        long mod = 1000000007L;
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-->0){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int n = sc.nextInt();
            long[] H = new long[n+1];
            H[0] = 2;
            H[1] = A;
            for (int i = 2; i < n + 1; i++) {
                long a = Math.floorMod(H[i-1]*H[1],mod);
                long b = Math.floorMod(H[i-2]*B,mod);
                H[i] = Math.floorMod(a-b,mod);
            }
            System.out.println(H[n]);
        }
    }
}
