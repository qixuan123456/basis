package com.qx.day21.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuan
 * @date 2022/6/10 09:46
 */
public class No730 {

    public static void main(String[] args) {

        System.out.println((-9)/(-2));
        System.out.println(countPalindromicSubsequences("bcbacbabdcbcbdcbddcaaccdcbbcdbcabbcdddadaadddbdbbbdacbabaabdddcaccccdccdbabcddbdcccabccbbcdbcdbd"));
    }

    public static int countPalindromicSubsequences(String s) {
        long mod = 1000000007L;
        int n = s.length();

        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                long add = 0;
                char temp = s.charAt(i);
                if (len > 2) {
                    add = dp[i + 1][j - 1];
                }
                if (temp == s.charAt(j)) {
                    int l = s.indexOf(temp, i + 1);
                    int r = s.lastIndexOf(temp,j-1);
                    if(l==-1||r==-1){
                        System.out.println("qwe");
                    }
                    if (l > r) {
                        dp[i][j] = 2 * add + 2;
                    } else if (l == r) {
                        dp[i][j] = 2 * add + 1;
                    } else {
                        if (l + 1 <= r - 1) {
                            dp[i][j] = 2 * add - dp[l + 1][r - 1];
                        } else {
                            dp[i][j] = 2 * add;
                        }
                    }

                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - add;
                }
                if(dp[i][j]<0){
                    dp[i][j]+=mod;
                }
                dp[i][j] %=mod;
            }
        }
        return (int)dp[0][n - 1];
    }




}
