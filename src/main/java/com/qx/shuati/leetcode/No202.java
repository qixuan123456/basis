package com.qx.shuati.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * User: xuan
 * Date: 2021/9/27
 * Time: 11:04
 */
public class No202 {
    public static void main(String[] args) {
        System.out.println(isHappy(109));
    }
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n!=1&&!set.contains(n)){
            set.add(n);
            n = getN(n);
        }
        return n==1;
    }

    public static int getN(int n){
        int res = 0;
        while(n!=0){
            int c = n%10;
            n = n/10;
            res += c*c;
        }
        return res;
    }
}
