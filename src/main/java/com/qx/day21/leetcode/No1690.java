package com.qx.day21.leetcode;

public class No1690 {
    public static void main(String[] args) {
        int[] stones = {7,90,5,1,100,10,10,2};
        System.out.println(stoneGameVII(stones));
    }
    public static int stoneGameVII(int[] stones) {
        int length = stones.length;
        int[][] dp = new int[length][length];
        int[][] num = new int[length][length];

        for(int i = 2;i <= length;i++){
            for (int j = 0; j <= length-i; j++) {
                if(i==2){
                    dp[j][j+1] = Math.max(stones[j],stones[j+1]);
                    num[j][j+1] = stones[j]+stones[j+1];
                }
                else{
                    dp[j][j+i-1] = Math.max(num[j+1][j+i-1]-dp[j+1][j+i-1],num[j][j+i-2]-dp[j][j+i-2]);
                    num[j][j+i-1] = num[j][j+i-2]+stones[j+i-1];
                }
            }
        }
        return dp[0][length-1];
    }
}
