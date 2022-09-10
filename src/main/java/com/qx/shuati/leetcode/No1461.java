package com.qx.shuati.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xuan
 * @date 2022/5/12 20:19
 */
public class No1461 {
    public static void main(String[] args) {

    }

    public boolean hasAllCodes(String s, int k) {
        Set<Integer> set = new HashSet<>();
        int l = (int) Math.pow(2,k);
        for (int i = 0; i < s.length()-k+1; i++) {
            int num = Integer.parseInt(s.substring(i,i+4),2);
            set.add(num);
            if(set.size()==l){
                return true;
            }
        }
        return false;
    }
}
