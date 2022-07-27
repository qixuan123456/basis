package com.qx;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuan
 * @date 2022/7/8 15:21
 */
public class No3 {
    public int buildTransferStation(int[][] area) {
//        int top = Integer.MIN_VALUE,left = Integer.MIN_VALUE,down = Integer.MAX_VALUE,right = Integer.MAX_VALUE;

        int m = area.length,n = area[0].length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(area[i][j]==1){
                    list.add(new int[]{i,j});
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = 0;
                for (int k = 0; k < list.size(); k++) {
                    int[] ints = list.get(k);
                    temp+=(Math.abs(ints[0]-i)+Math.abs(ints[1]-j));
                }
                ans = Math.min(temp,ans);
            }
        }
        return ans;
    }
}
