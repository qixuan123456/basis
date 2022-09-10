package com.qx.shuati.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xuan
 * @date 2022/7/4 14:40
 */
public class No1000 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int current = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int a = arr[i + 1] - arr[i];
            if (a < current) {
                ans.clear();
                current = a;
                ans.add(new ArrayList<>(Arrays.asList(arr[i], arr[i + 1])));
            } else if (a == current) {
                ans.add(new ArrayList<>(Arrays.asList(arr[i], arr[i + 1])));
            }
        }
        return ans;
    }
}
