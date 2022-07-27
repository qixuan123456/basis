package com.qx;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xuan
 * @date 2022/7/8 14:15
 */
public class No1 {
    public boolean canReceiveAllSignals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<intervals[i-1][1]){
                return false;
            }
        }
        return true;
    }
}
