package com.qx.bishi.qianxin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/25 20:03
 */
public class No2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] nums = Arrays.stream(input.substring(1,input.length()-1).split(" ")).mapToInt(Integer::parseInt).toArray();
        int l = 0,r = nums.length-1;
        int ans = Integer.MIN_VALUE;
        while(l<r){
            int current = (r-l)*Math.min(nums[r],nums[l]);
            ans = Math.max(ans,current);
            if(nums[r]<nums[l]){
                r--;
            }else {
                l++;
            }
        }
        System.out.println(ans);
    }
}
