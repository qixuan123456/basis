package com.qx.shuati.niuke.tengxun2021heji;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/4/15 11:00
 */
public class No3 {

    //超时
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            int min = nums[i + 1];
            for (int j = i + 1; j < n; j++) {
                if (j == i + 1) {
                    ans++;
                    continue;
                }
                if (min >= nums[i] && min >= nums[j]) {
                    min = nums[j];
                    ans++;
                }else {
                    if(min<nums[i]&&min<nums[j]){
                        break;
                    }
                    if(min<nums[i]){
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
