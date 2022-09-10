package com.qx.shuati.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xuan
 * Date: 2021/11/2
 * Time: 18:09
 */
public class No547 {
    public static void main(String[] args) {
        int[][] isConnected = {{1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}};
        No547 no547 = new No547();
        System.out.println(no547.findCircleNum(isConnected));
    }
    Set<Integer> set = new HashSet<>();
    int res = 0;
    public int findCircleNum(int[][] isConnected) {
        int i = 0;
        for (int j = 0; j < isConnected.length; j++) {
            if(!set.contains(j)){
                res++;
                set.add(j);
                dfs(j,isConnected);
            }

        }
        return res;
    }
    public void dfs(int i,int[][] isConnected){
        for (int j = 0; j < isConnected.length; j++) {
            if(isConnected[i][j]==1){

                if(!set.contains(j)){
                    set.add(j);
                    dfs(j,isConnected);
                }
            }
        }
    }
}
