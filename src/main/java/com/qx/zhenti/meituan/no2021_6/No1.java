package com.qx.zhenti.meituan.no2021_6;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/15 20:39
 */
public class No1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int ans = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i]>=k){
                count++;
            }else {
                ans+=Math.max(0,count-m+1);
                count = 0;
            }
        }
        if(count!=0){
            ans+=Math.max(0,count-m+1);
        }
        System.out.println(ans);
    }
}
