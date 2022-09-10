package com.qx.shuati.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuan
 * @date 2022/5/12 16:07
 */
public class No395 {
    public static void main(String[] args) {
        System.out.println(new No395().longestSubstring("aaabba",3));
    }
    public int ans = 0;
    public int longestSubstring(String s, int k) {
        if(s.length()>=k){
            dfs(s,k);
        }
        return ans;
    }

    public void dfs(String s,int k){
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        map.forEach((a,b)->{
            if(b<k){
                sb.append(a).append(' ');
            }
        });
        sb.append(']');
        if(sb.length()==2){
            ans = Math.max(ans,s.length());
            return;
        }
        String[] ss = s.split(sb.toString());
        int ans = 0;
        for (String value : ss) {
            if (value.length() >= k&&value.length()>ans) {
                dfs(value,k);
            }
        }
    }
}
