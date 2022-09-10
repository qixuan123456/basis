package com.qx.bishi.xiaohongshu.second;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/9/4 16:37
 */
public class No1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arg = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arg[0];
        int k = arg[2];
        int a = k%(2*n);
        if(a<n){
            if(a==0){
                System.out.println(nums[n-1]);
            }else {
                System.out.println(nums[a-1]);
            }
        }else {
            System.out.println(nums[2*n-a]);
        }
    }
}
