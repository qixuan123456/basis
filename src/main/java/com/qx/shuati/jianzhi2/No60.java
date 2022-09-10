package com.qx.shuati.jianzhi2;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2022/7/4 17:55
 */
public class No60 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dicesProbability(3)));
    }
    public static double[] dicesProbability(int n) {
        int[][] temp = new int[n + 1][n * 6 + 1];
        double[] ans = new double[n*5+1];
        for (int i = 1; i <= 6; i++) {
            temp[1][i] = 1;
        }
        for (int i = 2; i < n + 1; i++) {
            for (int j = i; j < n * 6 + 1; j++) {
                for (int k = 1; k <= 6; k++) {
                    if(j>=k){
                        temp[i][j] += temp[i-1][j-k];
                    }
                }
            }
        }
        double a = Math.pow(6,n);
        for (int i = 0; i < ans.length; i++) {
            ans[i] = temp[n][i+n]/a;
        }
        return ans;
    }

}
