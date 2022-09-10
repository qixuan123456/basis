package com.qx.shuati.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Xuan
 * Date: 2021/12/23
 * Time: 15:45
 */
public class No1044 {

    public static void main(String[] args) {
        String s = "aaaaabbbbbcccccdddddeeeeefffffttttt";
        System.out.println(new No1044().longestDupSubstring(s));
    }

    long[] h, p;
    public String longestDupSubstring(String s) {
        int N = 1313131;
        int n = s.length();
        h = new long[n + 1];
        p = new long[n + 1];
        p[0] = 1;
        for (int i = 0; i < n; i++) {
            h[i + 1] = h[i] * N + s.charAt(i);
            p[i + 1] = p[i] * N;
        }
        int l = 0;
        int r = n;
        String res = "";
        while (l < r) {
            int mid = (l + r + 1) / 2;
            String c = check(s, mid);
            if (c.length()!=0) {
                l = mid;
                res = c.length()>res.length()?c:res;
            } else {
                r = mid-1;
            }
        }
        return res;
    }

    public String check(String s, int len) {
        Set<Long> set = new HashSet<>();
        for (int i = 0; i + len - 1 < s.length(); i++) {
            int j = i + len - 1;
            long c = h[j+1] - h[i] * p[j - i + 1];
            if (set.contains(c)) {
                return s.substring(i, j+1);
            } else {
                set.add(c);
            }
        }
        return "";
    }
}
