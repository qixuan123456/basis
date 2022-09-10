package com.qx.zhenti.wangyileihuo.wangyileihuo1;

import java.util.*;

/**
 * @author xuan
 * @date 2022/6/17 10:32
 */
public class No5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int H = sc.nextInt();
        init(W,H);

    }

    public static void init(int w,int h){
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        set2.add(1<<2);
        set3.add(1<<3);
        for (int i = 4; i < w + 1; i++) {
            Set<Integer> set = new HashSet<>();
            for (Integer integer : set1) {
                set.add((integer<<3)+(1<<3));
            }

            for (Integer integer : set2) {
                set.add((integer<<2)+(1<<2));
            }
            set1 = set2;
            set2 = set3;
            set3 = set;
        }

        if(w==2){
            set3 = set2;
        }
        if(w==1){
            set3 = set1;
        }
        long[][] dp = new long[h][w];
        int n = set3.size();
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        int a = 1<<w;
        List<Integer> list = new ArrayList<>(set3);
        for (int i = 1; i <h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if((list.get(j)&list.get(k))==a){
                        dp[i][j] += dp[i-1][k];
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans+=dp[h-1][i];
        }
        System.out.println(ans);
    }
}
