package com.qx.zhenti.meituan.no2021_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/6 16:42
 */
public class No1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] r = new int[m][2];
        for (int i = 0; i < m; i++) {
            r[i][0] = scanner.nextInt();
            r[i][1] = scanner.nextInt();
        }
        UnionFind unionFind = new UnionFind();
        unionFind.init(n + 1);
        for (int i = 0; i < m; i++) {
            if (r[i][0] != r[i][1]) {
                unionFind.put(r[i][0], r[i][1]);
            }
        }
        for (int i = 0; i < unionFind.g.length; i++) {
            unionFind.g[i].sort(Integer::compare);
        }

        Arrays.sort(unionFind.g, 1, unionFind.g.length, (a, b) -> {
            if (a.isEmpty()) {
                return -1;
            }
            if (b.isEmpty()) {
                return 1;
            }
            return a.get(0) - b.get(0);
        });
        int a = 0;
        for (int i = 1; i < unionFind.g.length; i++) {
            if (!unionFind.g[i].isEmpty()) {
                a++;
            }
        }
        System.out.println(a);
        for (int i = 1; i < unionFind.g.length; i++) {
            if (unionFind.g[i].isEmpty()) {
                continue;
            } else {
                for (int j = 0; j < unionFind.g[i].size(); j++) {
                    if (j == 0) {
                        System.out.print(unionFind.g[i].get(j));
                    }else {
                        System.out.print(" "+unionFind.g[i].get(j));
                    }

                }
                System.out.println();
            }
        }
    }


    static public class UnionFind {
        int[] group;
        int[] weight;
        List<Integer>[] g;

        public void init(int n) {
            group = new int[n];
            weight = new int[n];
            g = new List[n];
            for (int i = 0; i < n; i++) {
                group[i] = i;
                weight[i] = 1;
                g[i] = new ArrayList();
                g[i].add(i);
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
                g[a].addAll(g[b]);
                g[b].clear();
            } else {
                group[a] = b;
                weight[b] += weight[a];
                g[b].addAll(g[a]);
                g[a].clear();
            }
        }
    }
}
