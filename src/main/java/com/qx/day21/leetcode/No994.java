package com.qx.day21.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Xuan
 * Date: 2022/1/4
 * Time: 20:33
 */
public class No994 {

    public static void main(String[] args) {
        int[][] grid = {{0,2}};
        System.out.println(orangesRotting(grid));
    }

    static Queue<int[]> queue = new LinkedList<>();
    static int ans = 0;
    static int sum1 = 0;

    public static int orangesRotting(int[][] grid) {
        int[][] grids = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, grids[i], 0, grid[0].length);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    sum1++;
                }
            }
        }
        bfs(grids);
        return sum1 == 0 ? ans : -1;
    }

    public static void bfs(int[][] grid) {
        int[] a;
        List<int[]> list = new ArrayList<>();
        while ((a = queue.poll()) != null) {
            int x = a[0];
            int y = a[1];
            if (x - 1 >= 0) {
                if (grid[x - 1][y] == 1) {
                    sum1--;
                    grid[x - 1][y] = 2;
                    list.add(new int[]{x - 1, y});
                }
            }
            if (x + 1 < grid.length) {
                if (grid[x + 1][y] == 1) {
                    sum1--;
                    grid[x + 1][y] = 2;
                    list.add(new int[]{x + 1, y});
                }
            }
            if(y-1>=0){
                if(grid[x][y-1]==1){
                    sum1--;
                    grid[x][y-1]=2;
                    list.add(new int[]{x,y-1});
                }
            }
            if(y+1<grid[0].length){
                if(grid[x][y+1]==1){
                    sum1--;
                    grid[x][y+1]=2;
                    list.add(new int[]{x,y+1});
                }
            }
            if (queue.isEmpty()) {
                queue.addAll(list);
                if(!list.isEmpty()){
                    list.clear();
                    ans++;
                }
            }
        }
    }
}
