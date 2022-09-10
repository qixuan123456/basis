package com.qx.zhenti.niuke.alibaba2021;

import java.util.Scanner;

/**
 * @author Xuan
 * Date: 2022/4/13
 * Time: 13:00
 */
public class No5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        double min = 0.0;
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                min = Math.max(min,Math.min((nums[i][0] + nums[j][0]) / 2.0,(nums[i][1] + nums[j][1]) / 2.0));
            }
        }
        System.out.printf("%.1f",min);
    }
}
