package com.qx.shuati.jingsai.no1;

/**
 * @author Xuan
 * Date: 2021/12/30
 * Time: 20:06
 */
public class No3 {
    public static void main(String[] args) {
        System.out.println(getDescentPeriods(new int[]{3,1,3,4}));
    }
    public static long getDescentPeriods(int[] prices) {
        int left = 0;
        long ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i-1]-prices[i]!=1){
                long c = (long)(i-left);
                ans += (1+c)*c/2;
                left = i;
            }
        }
        long c = (long) (prices.length-left);
        ans += (1+c)*c/2;
        return ans;
    }
}
