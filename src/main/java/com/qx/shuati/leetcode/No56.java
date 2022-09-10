package com.qx.shuati.leetcode;


import com.qx.shuati.tool.Util;

import java.util.Arrays;
import java.util.Comparator;

public class No56 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};


        int[][] a = merge(intervals);
        Util.print2Array(a);
    }
    public static int[][] merge(int[][] intervals) {
        if(intervals.length<1){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[][] a = new int[intervals.length][2];
        int i = 1;
        int j = 0;
        a[0] = intervals[0];
        while (i<intervals.length){
            if(a[j][1]<intervals[i][0]){
                j++;
                a[j] = intervals[i];
                i++;
            }else if(a[j][1]>=intervals[i][0]&&a[j][1]<intervals[i][1]){
                a[j][1] = intervals[i][1];
                i++;
            }
            else{
                i++;
            }
        }
        int[][] aws = new int[j+1][2];
        System.arraycopy(a,0,aws,0,j+1);
        return  aws;
    }
}
