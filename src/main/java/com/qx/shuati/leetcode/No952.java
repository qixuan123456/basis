package com.qx.shuati.leetcode;

import java.util.*;

/**
 * @author xuan
 * @date 2022/7/30 12:10
 */
public class No952 {

    public static void main(String[] args) {
        No952 no952 = new No952();
        System.out.println(no952.largestComponentSize(new int[]{4,6,15,35}));
    }

    public int largestComponentSize(int[] nums) {
        int m = Arrays.stream(nums).max().getAsInt();
        UnionFind uf = new UnionFind(m + 1);
        for (int num : nums) {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    uf.union(num, i);
                    uf.union(num, num / i);
                }
            }
        }
        int[] counts = new int[m + 1];
        int ans = 0;
        for (int num : nums) {
            int root = uf.find(num);
            counts[root]++;
            ans = Math.max(ans, counts[root]);
        }
        return ans;
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        rank = new int[n];
    }

    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else {
                parent[rooty] = rootx;
                rank[rootx]++;
            }
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }


//    Map<Integer, List<Integer>> map;
//    Map<Integer,List<Integer>> relation;
//    public int largestComponentSize(int[] nums) {
//        map = new HashMap<>();
//        relation = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            getFactor(nums[i]);
//        }
//
//        init(Arrays.stream(nums).max().getAsInt()+1);
//
//        for (Map.Entry<Integer,List<Integer>> entry : relation.entrySet()) {
//            for (Integer a : entry.getValue()) {
//                put(entry.getKey(),a);
//            }
//        }
//        return Arrays.stream(weight).max().getAsInt();
//    }
//
//    int[] group;
//    int[] weight;
//
//    public void init(int n) {
//        group = new int[n];
//        weight = new int[n];
//        for (int i = 0; i < n; i++) {
//            group[i] = i;
//            weight[i] = 1;
//        }
//    }
//
//    public int get(int i) {
//        if (group[i] != i) {
//            i = get(group[i]);
//        }
//        return i;
//    }
//
//    public void put(int a, int b) {
//        a = get(a);
//        b = get(b);
//        if (a == b) {
//            return;
//        }
//        if (weight[a] > weight[b]) {
//            group[b] = a;
//            weight[a] += weight[b];
//        } else {
//            group[a] = b;
//            weight[b] += weight[a];
//        }
//    }
//
//    public void getFactor(int num) {
//        double q = Math.sqrt(num);
//        for (int i = 1; i <= q; i++) {
//            if(num%i==0){
//                if(i!=1&&map.containsKey(i)){
//                    List<Integer> list = map.get(i);
//                    int a = list.get(list.size()-1);
//                    List<Integer> orDefault = relation.getOrDefault(a, new ArrayList<>());
//                    orDefault.add(num);
//                    relation.put(a,orDefault);
//                    list.add(num);
//                }else {
//                    List<Integer> list = new ArrayList<>();
//                    list.add(num);
//                    map.put(i,list);
//                }
//
//                int c = num/i;
//                if(c==i){
//                    continue;
//                }
//                if(c!=1&&map.containsKey(c)){
//                    List<Integer> list = map.get(c);
//                    int a = list.get(list.size()-1);
//                    List<Integer> orDefault = relation.getOrDefault(a, new ArrayList<>());
//                    orDefault.add(num);
//                    relation.put(a,orDefault);
//                    list.add(num);
//                }else {
//                    List<Integer> list = new ArrayList<>();
//                    list.add(num);
//                    map.put(c,list);
//                }
//            }
//        }
//    }
}
