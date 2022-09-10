package com.qx.bishi.xiecheng;

import java.util.*;

/**
 * @author xuan
 * @date 2022/8/30 19:45
 */
public class No4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int index = 0;
        int cha = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            int a = Math.abs(nums[i]-nums[i-1]);
            if(a>cha){
                index = i;
                cha = a;
            }

        }
        int ans = Integer.MIN_VALUE;
        if(index == n-1){
            nums[index] = nums[index-1];
            for (int i = 1; i < nums.length; i++) {
                ans = Math.max(Math.abs(nums[i]-nums[i-1]),ans);
            }
            System.out.println(ans);
        }else {
            int ans1 = Integer.MIN_VALUE;
            int a = nums[index];
            nums[index] = (nums[index+1]+nums[index-1])/2;
            for (int i = 1; i < nums.length; i++) {
                ans1 = Math.max(Math.abs(nums[i]-nums[i-1]),ans1);
            }
            nums[index] = a;
            int ans2 = Integer.MIN_VALUE;
            if(index==1){
                for (int i = 2; i < nums.length; i++) {
                    ans2 = Math.max(Math.abs(nums[i]-nums[i-1]),ans2);
                }
            }else{
                nums[index-1] = (nums[index]+nums[index-2])/2;
                for (int i = 1; i < nums.length; i++) {
                    ans2 = Math.max(Math.abs(nums[i]-nums[i-1]),ans2);
                }
            }
            System.out.println(Math.min(ans1,ans2));
        }
    }
}
