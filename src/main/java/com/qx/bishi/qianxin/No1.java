package com.qx.bishi.qianxin;

/**
 * @author xuan
 * @date 2022/8/25 19:50
 */
public class No1 {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {3}, {3}, {4}, {}};
        System.out.println(DagPathNum(nums));
    }

    public static int DagPathNum(int[][] nodes) {
        // write code here
        return dfs(nodes, 0);
    }

    public static int dfs(int[][] nodes, int current) {
        int res = 0;
        if (current == nodes.length-1) {
            return 1;
        }

        for (int i = 0; i < nodes[current].length; i++) {
            res += dfs(nodes, nodes[current][i]);
        }
        return res;
    }
}
