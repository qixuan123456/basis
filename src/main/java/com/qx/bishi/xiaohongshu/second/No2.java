package com.qx.bishi.xiaohongshu.second;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/9/4 17:02
 */
public class No2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long res = 0;
        int max_index = 0;
        int max_dis = Math.abs(nums[0]);
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if (!flag && nums[i] == 0) {
                flag = true;
            }
            if (Math.abs(nums[i]) > max_dis) {
                max_index = i;
                max_dis = Math.abs(nums[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == max_index) {
                res += Math.min(Math.abs(nums[i] + 7), Math.abs(nums[i] - 7));
                nums[i] = nums[i] >= 0 ? 7 : -7;
            } else {
                res += Math.min(Math.abs(nums[i] + 1), Math.abs(nums[i] - 1));
                nums[i] = nums[i] >= 0 ? 1 : -1;
            }
        }

        if(flag){
            System.out.println(res);
        }else {
            int ans =1;
            for (int i = 0; i < n; i++) {
                ans*=nums[i];
            }
            if(ans==7){
                System.out.println(res);
            }else {
                System.out.println(res+2);
            }
        }
    }
}
