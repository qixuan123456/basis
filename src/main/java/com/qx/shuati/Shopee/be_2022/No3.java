package com.qx.shuati.Shopee.be_2022;

/**
 * @author xuan
 * @date 2022/7/19 20:02
 */
public class No3 {

    public int petalsBreak (int[] petals) {
        // write code here

        int ans = 0;
        for (int i = 0; i < petals.length; i++) {
            ans = ans+(petals[i]+1)/2;
        }
        return ans;
    }
}
