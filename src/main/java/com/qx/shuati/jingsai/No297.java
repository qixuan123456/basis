package com.qx.shuati.jingsai;

import java.util.*;

/**
 * @author xuan
 * @date 2022/6/16 15:37
 */
public class No297 {

    public double calculateTax(int[][] brackets, int income) {
        double ans = 0.0;
        for (int i = 0; i < brackets.length; i++) {
            if (income > brackets[i][0]) {
                if (i == 0) {
                    ans += (brackets[i][0] * ((double) (brackets[i][1])) / 100);
                } else {
                    ans += ((brackets[i][0] - brackets[i - 1][0]) * ((double) (brackets[i][1])) / 100);
                }
            } else {
                if (i == 0) {
                    ans += (income) * ((double) (brackets[i][1])) / 100;
                } else {
                    ans += (income - brackets[i - 1][0]) * ((double) (brackets[i][1])) / 100;
                }
                break;
            }
        }
        return ans;
    }


    public int minPathCost(int[][] grid, int[][] moveCost) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < m; k++) {
                    min = Math.min(min, dp[i - 1][k] + moveCost[grid[i - 1][k]][j] + grid[i][j]);
                }
                dp[i][j] = min;
            }
        }
        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }

    int min = Integer.MAX_VALUE;
    int k;
    int[] cookies;
    public int distributeCookies(int[] cookies, int k) {
        Arrays.sort(cookies);
        this.cookies = cookies;
        this.k = k;
        dfs(new int[k],cookies.length-1);

        return min;
    }
    public void dfs(int[] people,int current){


        if(current == -1){
            min = Math.min(min,Arrays.stream(people).max().getAsInt());
            return;
        }

        int sum = 0;

        for (int i = 0; i < k; i++) {
            if(people[i]==0){
                sum++;
            }
        }
        if(sum>current+1){
            return;
        }

        if(Arrays.stream(people).max().getAsInt()>min){
            return;
        }

        for (int i = 0; i < k; i++) {
            people[i]+=cookies[current];
            dfs(people,current-1);
            people[i]-=cookies[current];
        }
    }

    public long distinctNames(String[] ideas) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < ideas.length; i++) {
            String s1 = ideas[i].substring(0, 1);
            String s2 = ideas[i].substring(1);
            if (set1.contains(s1)) {

            }
        }
        return 1;
    }



    public static void main(String[] args) {
        int[][] grid = {{5, 3}, {4, 0}, {2, 1}};
        int[][] moveCost = {{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}};

        System.out.println(new No297().minPathCost(grid, moveCost));
    }

}
