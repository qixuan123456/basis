package com.qx.bishi.zijie;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/9/4 19:07
 */
public class No2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m =scanner.nextInt();

        scanner.nextLine();
        int[][] nums = new int[n][m];

        for (int i = 0; i < n; i++) {
            nums[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[][] dp = new int[n][m];

        for (int i = 0; i < m; i++) {
            if(nums[0][i]!=-1){
                dp[0][i] = nums[0][i];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean flag = false;
                if(j>0&&nums[i-1][j-1]==-1){
                    if(nums[i][j]==-1){
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]);
                    }else {
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+nums[i][j]);
                    }
                    flag = true;
                }
                if(j+1<m&&nums[i-1][j+1]==-1){
                    if(nums[i][j]==-1){
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j+1]);
                    }else{
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j+1]+nums[i][j]);
                    }
                    flag = true;
                }
                if(dp[i][j]!=-2&&nums[i-1][j]!=-1){
                    if(nums[i][j]==-1){
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j]);
                    }else {
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][j]+nums[i][j]);
                    }
                    flag = true;
                }
                if(!flag){
                    dp[i][j] = -2;
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            if(nums[n-1][i]!=-1){
                ans = Math.max(ans,dp[n-1][i]);
            }
        }
        System.out.println(ans);

    }
}
