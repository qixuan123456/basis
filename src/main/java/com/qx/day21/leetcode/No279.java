package com.qx.day21.leetcode;

import java.util.*;

/**
 * @author Xuan
 * Date: 2022/3/29
 * Time: 13:52
 */
public class No279 {
    public static void main(String[] args) {
        System.out.println(numSquares(234));
    }
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,100);
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<n+1;i++){
            int sqrt = (int)Math.sqrt(i);
            for(int j=1;j<=sqrt;j++){
                int s = i-j*j;
                if(s==0){
                    dp[i]=1;
                }else {
                    dp[i] = Math.min(dp[s]+dp[j*j],dp[i]);
                }
            }
        }
        return dp[n];
    }
}
