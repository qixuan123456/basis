package com.qx.bishi.yongyou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/9/9 19:42
 */
public class No2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.length() == 0) {
                break;
            }
            list.add(s);
        }
        int[][] nums = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = Arrays.stream(list.get(i  ).split(",")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(max(nums));

    }

    public static int max(int[][] grid) {
        int max = 0, area = 0;
        int n = grid.length, m = grid[0].length;
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j] == 0 && grid[i][j] == 1) {
                    area = dfs(i, j, grid, nums, 0);
                    max = Math.max(area, max);
                }
            }
        }
        return max;
    }

    public static int dfs(int i, int j, int[][] grid, int[][] nums, int area) {
        nums[i][j] = 1;
        area++;
        if (i - 1 >= 0 && nums[i - 1][j] == 0 && grid[i - 1][j] == 1) {
            area = dfs(i - 1, j, grid, nums, area);
        }
        if (i + 1 <= grid.length - 1 && nums[i + 1][j] == 0 && grid[i + 1][j] == 1) {
            area = dfs(i + 1, j, grid, nums, area);
        }
        if (j - 1 >= 0 && nums[i][j - 1] == 0 && grid[i][j - 1] == 1) {
            area = dfs(i, j - 1, grid, nums, area);
        }
        if (j + 1 <= grid[0].length - 1 && nums[i][j + 1] == 0 && grid[i][j + 1] == 1) {
            area = dfs(i, j + 1, grid, nums, area);
        }
        return area;
    }
}
