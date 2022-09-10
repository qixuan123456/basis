package com.qx.bishi.xiaohongshu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/28 16:50
 */
public class No2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arg = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //long a = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(nums);

        int target = arg[1], n = arg[0];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i!=j&&nums[i]*nums[j]>=target){
                    ans++;
                }
            }
        }
//        for (int i = 0; i < n-1; i++) {
//            int left = i + 1, right = nums.length;
//            while (left < right) {
//                int mid = (left + right) >> 1;
//                if (nums[i] * nums[mid] >= target) {
//                    right = mid;
//                } else {
//                    left = mid+1;
//                }
//            }
//            ans+=(n-left);
//        }
        System.out.println(ans*2);
    }
}
