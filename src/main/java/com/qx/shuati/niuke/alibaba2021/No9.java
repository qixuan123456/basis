package com.qx.shuati.niuke.alibaba2021;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * @author Xuan
 * Date: 2022/4/13
 * Time: 13:48
 */
public class No9 {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int left = 0;
        int right = m-1;
        boolean flag =false;
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int c = map.getOrDefault(nums[i],0);
            map.put(nums[i],c+1);
            if(c==m){
                flag = true;
            }
        }
        while(left<n-m+1&&right<n){
            if(flag){
                res+=(n-right);
                map.put(nums[left],map.get(nums[left])-1);
                left++;
                flag = map.get(nums[right])==m;
            }else{
                right++;
                if(right<n){
                    int c = map.getOrDefault(nums[right],0)+1;
                    map.put(nums[right],c);
                    if(c==m){
                        flag = true;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
