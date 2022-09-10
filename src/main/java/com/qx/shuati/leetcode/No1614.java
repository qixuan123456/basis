package com.qx.shuati.leetcode;

/**
 * @author Xuan
 * Date: 2022/1/7
 * Time: 20:24
 */
public class No1614 {

    public static void main(String[] args) {
        String s = "";
        System.out.println(maxDepth(s));
    }
    public static int maxDepth(String s) {
        int ans = 0;
        int current = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('){
                current++;
                ans = Math.max(current,ans);
            }else if (c==')'){
                current--;
            }
        }
        return ans;
    }
}
