package com.qx.day21.jingsai;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2022/4/24 18:16
 */
public class No290 {

    public int[] countRectangles(int[][] rectangles, int[][] points) {

        int[] ans1 = new int[points.length];

        for(int i=0;i<points.length;i++){
            for(int j=0;j<rectangles.length;j++){
                if(points[i][0]<=rectangles[j][0]&&points[i][1]<=rectangles[j][1]){
                    ans1[i]++;
                }
            }

        }
        return ans1;
    }
}
