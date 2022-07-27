package com.qx.shuati.pinduoduo.xiaozhao2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/7/14 13:03
 */
public class No1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        if(nums[N-1]<0){
            System.out.println(nums[N-1]*nums[N-2]*nums[N-3]);
            return;
        }
        System.out.println(nums[N-1]*(Math.max(nums[N-2]*nums[N-3],nums[0]*nums[1])));
    }
}
