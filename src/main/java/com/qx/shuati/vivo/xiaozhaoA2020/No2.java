package com.qx.shuati.vivo.xiaozhaoA2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author xuan
 * @date 2022/7/7 12:50
 */
public class No2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int solution(int[] input) {

        // TODO Write your code here
        int n = input.length;
        int[][] dp = new int[n+1][n+1];
        int left = 0,right = 0;
        while(right<n){
            if(input[left]==input[right]){
                dp[left+1][right+1] = (int) Math.pow(right-left+1,2);
                right++;
            }else {
                left++;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= n - i+1; j++) {
                if(i==1){
                    dp[j][j+i-1] = 1;
                    continue;
                }
                for (int k = 0; k < i; k++) {
                    int a = 0;
                    if(j+k<j+i-1){
                        a = dp[j+k][j+i-1];
                    }
                    dp[j][j+i-1] = Math.max(dp[j][j+i-1],dp[j][j+k-1]+a);
                }
            }
        }
        return dp[1][n];
    }
}
