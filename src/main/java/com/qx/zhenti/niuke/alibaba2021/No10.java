package com.qx.zhenti.niuke.alibaba2021;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/4/14 20:50
 */
public class No10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 1;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            map.put(b[i],i);
        }

        int current = 1;
        for (int i = 1; i < n; i++) {
            if(map.get(a[i])>map.get(a[i-1])){
                current++;
                ans = Math.max(ans,current);
            }else{
                current = 1;
            }
        }
        System.out.println(n-ans);
    }
}
