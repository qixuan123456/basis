package com.qx.day21.jingsai.no250;

import com.qx.day21.tool.Util;

public class No4 {
    public static void main(String[] args) {
        int[] parents = {3, 7, -1, 2, 0, 7, 0, 2};
        int[][] queries = {{4, 6}, {1, 15}, {0, 5}};//[[4,6],[1,15],[0,5]]
        int[] ans = maxGeneticDifference(parents, queries);
        Util.printArray(ans);
    }

    public static int[] maxGeneticDifference(int[] parents, int[][] queries) {
        int[] ans = new int[queries.length];
        //int root = find(parents,-1);
        for (int i = 0; i < ans.length; i++) {
            int w = queries[i][0];
            while (w != -1) {
                ans[i] = Math.max(ans[i], w ^ queries[i][1]);
                w = parents[w];
            }
        }
        return ans;
    }

    public static int find(int[] parents, int a) {
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == a)
                return i;
        }
        return 0;
    }
}
