package com.qx.shuati.jingsai.doublce;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuan
 * @date 2022/6/27 20:29
 */
public class No81 {

    public static void main(String[] args) {
        new No81().countAsterisks("|**|");
    }

    public int countAsterisks(String s) {
        int ans = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (flag) {
                if (c == '*') {
                    ans++;
                }
                if (c == '|') {
                    flag = false;
                }
            } else {
                if (c == '|') {
                    flag = true;
                }
            }
        }
        return ans;
    }

    int[] group;
    int[] weight;

    public long countPairs(int n, int[][] edges) {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            map.put(i,new ArrayList<>());
//        }
//
//        for (int i = 0; i < edges.length; i++) {
//            map.get()
//        }
        group = new int[n];
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
            weight[i] = 1;
        }
        for (int i = 0; i < edges.length; i++) {
            put(edges[i][0], edges[i][1]);
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int a = get(i);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        long sum = 0;
        long ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans += sum * entry.getValue();
            sum += entry.getValue();
            System.out.println(ans);
        }
        return ans;
    }

    public int get(int i) {
        if (group[i] != i) {
            i = get(group[i]);
        }
        return i;
    }


    public void put(int a, int b) {
        a = get(a);
        b = get(b);
        if (a == b) {
            return;
        }
        if (weight[a] > weight[b]) {
            group[b] = a;
            weight[a] += weight[b];
        } else {
            group[a] = b;
            weight[b] += weight[a];
        }
    }


    public int maximumXOR(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans |= num;
        }
        return ans;
    }
}
