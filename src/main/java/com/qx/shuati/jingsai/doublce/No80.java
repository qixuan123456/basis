package com.qx.shuati.jingsai.doublce;

import java.util.*;

/**
 * @author xuan
 * @date 2022/6/13 14:57
 */
public class No80 {

    public boolean strongPasswordCheckerII(String password) {
        boolean small = false, big = false, digital = false, special = false;
        String s = "!@#$%^&*()-+";
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (i > 0) {
                if (c == password.charAt(i - 1)) {
                    return false;
                }
            }
            if (Character.isDigit(c)) {
                digital = true;
            }
            if (Character.isUpperCase(c)) {
                big = true;
            }
            if (Character.isLowerCase(c)) {
                small = true;
            }
            if (s.contains(String.valueOf(c))) {
                special = true;
            }


        }
        return password.length() >= 8 && small && big && digital && special;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        int n = potions.length;
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int left = 0,right = n;

            while (left<right){
                int mid = (left+right)>>1;
                if((long)spells[i] * potions[mid]>=success){
                    right = mid;
                }else {
                    left = mid+1;
                }
            }
            ans[i] = n-left+1;
        }
        return ans;
    }

    public static boolean matchReplacement(String s, String sub, char[][] mappings) {
        int n = sub.length();
        Map<Character, Set<Character>> map = new HashMap<>();
        for (char[] mapping : mappings) {
            Set<Character> set = map.getOrDefault(mapping[0],new HashSet<>());
            set.add(mapping[1]);
            map.put(mapping[0], set);
        }
        for (int i = 0; i <= s.length()-n; i++) {
            String a = s.substring(i,i+n);
            char[] chars = sub.toCharArray();
            int j = 0;
            for (; j < n; j++) {
                if(a.charAt(j)!=chars[j]){
                    if(!map.containsKey(chars[j])||!map.get(chars[j]).contains(a.charAt(j))){
                        break;
                    }
                }
            }
            if(j==n){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(matchReplacement("fool3e7bar", "leet", new char[][]{{'e', '3'}, {'t', '7'}, {'t', '8'}}));
    }
    public static long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long ans = 0;

        long[] pre = new long[n+1];
        for (int i = 0; i < n; i++) {
            pre[i+1] = pre[i]+nums[i];
        }
        for (int i = 0; i < n; i++) {
            if(nums[i]>=k){
             continue;
            }
            int left = i,right = n-1;
            while (left<right){
                int mid = (left+right+1)>>1;
                if((long)(mid-i+1)*(pre[mid+1]-pre[i])>=k){
                    right = mid-1;
                }else {
                    left = mid;
                }
            }
            ans+= (left-i+1);
        }
        return ans;
    }
}
