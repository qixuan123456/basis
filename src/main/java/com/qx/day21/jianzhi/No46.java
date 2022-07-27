package com.qx.day21.jianzhi;

/**
 * @author xuan
 * @date 2022/6/23 13:17
 */
public class No46 {
    public static void main(String[] args) {
        new No46().translateNum(1001);
    }
    public int translateNum(int num) {
        String s = Integer.toString(num);
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = ans;
            char c = s.charAt(i-1);
            if(c=='1'||(c=='2'&&s.charAt(i)<='5')){
                ans += dp[i-1];
            }
        }
        return ans;
    }
}
