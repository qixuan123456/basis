package com.qx.shuati.leetcode;

/**
 * @author xuan
 * @date 2022/8/16 18:46
 */
public class No2376 {

    public static void main(String[] args) {
        System.out.println(countSpecialNumbers(135));
    }

    static String s;

    public static int countSpecialNumbers(int n) {
        s = String.valueOf(n);
        return dfs(0, 0, false, true);
    }

    public static int dfs(int index, int mask, boolean isNum, boolean isLimit) {
        if (index == s.length()) {
            return isNum ? 1 : 0;
        }
        int res = 0;

        if (!isNum) {
            res += dfs(index + 1, mask, false, false);
        }

        int limit = isLimit ? s.charAt(index) - '0' : 9;

        for (int i = isNum ? 0 : 1; i <= limit; i++) {
            if (((mask >> i) & 1) == 0) {
                res += dfs(index + 1, mask | (1 << i), true, i == limit && isLimit);
            }
        }
        return res;
    }
}
