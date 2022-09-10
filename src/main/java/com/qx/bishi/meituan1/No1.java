package com.qx.bishi.meituan1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/13 16:12
 */
public class No1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int t = scanner.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int ans = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<t){
                ans++;
                continue;
            }

            if(nums[i]-current>=t){
                current = current+t;
            }else {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
