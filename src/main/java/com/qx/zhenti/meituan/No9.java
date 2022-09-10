package com.qx.zhenti.meituan;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/5/11 13:35
 */
public class No9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int mod = 998244353;
        long[][] nums = new long[M+1][N+1];
        for (int i = 1; i < N + 1; i++) {
            nums[1][i] = 1;
        }
        for (int i = 2; i < M + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                double a = Math.sqrt(j);
                for (int k = 1;k <= a; k++) {
                   if(j%k==0){
                       nums[i][j]+=nums[i-1][k];
                       if(k!=j/k){
                           nums[i][j]+=nums[i-1][j/k];
                       }
                       nums[i][j]%=mod;
                   }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i < N + 1; i++) {
            ans+=nums[M][i];
            ans%=mod;
        }
        System.out.println(ans);
    }
}
