package com.qx.shuati.pinduoduo.xiaozhao2020;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/7/6 20:51
 */
public class No4 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N+1];
        int max = 0;
        for (int i = 1; i < N + 1; i++) {
            nums[i] = scanner.nextInt();
            max = Math.max(max,nums[i]);
        }
        Arrays.sort(nums);
        double[][] t = new double[N+1][max+1];
        for (int i = 0; i < max + 1; i++) {
            t[0][i] = 1;
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < nums[i]+1; j++) {
                if(i==1){
                    t[i][j] = 1.0/nums[i];
                    continue;
                }
                if(j>nums[i-1]){
                    t[i][j] = 1.0/nums[i];
                }else {
                    double a = 0.0;
                    for (int k = 1; k <= j; k++) {
                        a+=t[i-1][k];
                    }
                    t[i][j] = a/nums[i];
                    t[i][j] += t[i-1][j]/nums[i]*(j-1);
                }
            }
        }
        double ans = 0;
        double v = 0;
        for (int i = 1; i < max + 1; i++) {
            ans+= (i*t[N][i]);
            v+=t[N][i];
        }
        System.out.println(v);
        System.out.println(new BigDecimal(ans).setScale(2, RoundingMode.HALF_UP));
    }
}
