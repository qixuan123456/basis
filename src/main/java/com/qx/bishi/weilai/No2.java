package com.qx.bishi.weilai;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/5 20:18
 */
public class No2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = scanner.nextInt();
        System.out.println(canP(nums,k));
    }
    public static Map<Integer,Boolean> memo = new HashMap<>();

    public static boolean canP(int[] nums,int k){
        if(k==1){
            return true;
        }

        int len = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%k!=0){
            return false;
        }
        int target = sum/k;

        if(nums[len-1]>target){
            return false;
        }

        int size = 1<<len;
        boolean[] dp = new boolean[size];
        dp[0] = true;
        int[] currentSum = new int[size];
        for (int i = 0; i < size; i++) {
            if(!dp[i]){
                continue;
            }
            for (int j = 0; j < len; j++) {
                if((i&(1<<j))!=0){
                    continue;
                }
                int next = i|(1<<j);
                if(dp[next]){
                    continue;
                }

                if(currentSum[i]%target+nums[j]<=target){
                    currentSum[next] = currentSum[i]+nums[j];
                    dp[next] = true;
                }else {
                    break;
                }
            }
        }
        return dp[sum-1];
    }
}
