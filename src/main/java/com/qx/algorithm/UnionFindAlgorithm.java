package com.qx.algorithm;

/**
 * @author xuan
 * @date 2022/7/19 21:10
 * 并查集
 */
public class UnionFindAlgorithm {
    int[] group;
    int[] weight;

    public void init(int n) {
        group = new int[n];
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            group[i] = i;
            weight[i] = 1;
        }
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
}
