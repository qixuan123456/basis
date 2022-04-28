package com.qx.day21.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class No438 {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ba";
        System.out.println(findAnagrams(s,p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        if(sl<pl)
            return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = pl - 1;
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        Arrays.sort(cp);
        while(right<sl){
            char[] c = new char[pl];
            System.arraycopy(cs,left,c,0,pl);
            Arrays.sort(c);
            for (int i = 0; i < pl; i++) {
                if(c[i]!=cp[i]){
                    break;
                }
                if(i==pl-1){
                    list.add(left);
                }
            }
            left++;
            right++;
        }
        return list;
    }
}
