package com.qx.shuati.jingsai;

import java.util.*;

/**
 * @author xuan
 * @date 2022/7/13 14:23
 */
public class No301 {


    public static int fillCups(int[] amount) {
        int ans = 0;
        Arrays.sort(amount);
        while (!(amount[0] == 0 && amount[1] == 0)) {
            amount[1]--;
            amount[2]--;
            Arrays.sort(amount);
            ans++;
        }
        return ans + amount[2];
    }


    TreeMap<Integer, Integer> map = new TreeMap<>();

    public int popSmallest() {
        int res = map.firstKey();
        map.remove(res);
        return res;
    }

    public void addBack(int num) {
        map.put(num, 0);
    }

    public boolean canChange(String start, String target) {
        if(!start.replace("_","").equals(target.replace("_",""))){
            return false;
        }
        int l = 0,r = 0;
        for (int i = 0; i < target.length(); i++) {
            if (start.charAt(i)=='L'){
                l--;
            }
            if(target.charAt(i)=='L'){
                l++;
            }
            if (start.charAt(i)=='R'){
                r++;
            }
            if(target.charAt(i)=='R'){
                r--;
            }
            if(l<0||r<0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(idealArrays(2, 5));
    }

    public static int idealArrays(int n, int maxValue) {
        int[][] dp = new int[n + 1][maxValue + 1];
        int mod = 1000000007;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < maxValue + 1; j++) {
                if (i == 1) {
                    dp[i][j] = j;
                    continue;
                }
                dp[i][j] = ((dp[i][j - 1] + dp[i - 1][j]) % mod - dp[i - 1][j - 1]) % mod;
            }
        }

        return dp[n][maxValue];
    }
}
