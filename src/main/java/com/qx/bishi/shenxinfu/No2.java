package com.qx.bishi.shenxinfu;

/**
 * @author xuan
 * @date 2022/9/1 19:56
 */
public class No2 {

    public int histogram_max_area(int[] histogram) {
        // write code here

        int ans = 0;
        int n = histogram.length;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                int height = Math.min(min,histogram[j]);
                int area = (j-i+1)*height;
                min = height;
                ans = Math.max(area,ans);
            }
        }
        return ans;
    }
}
