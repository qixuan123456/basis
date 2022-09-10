package com.qx.shuati.leetcode;

import java.util.*;

/**
 * @author Xuan
 * Date: 2021/12/21
 * Time: 13:05
 */
public class No49 {

    public static void main(String[] args) {
        String[] strs = {"eatttt", "teaaaa", "tan", "ate", "nat", "bat"};
        System.out.println(new No49().groupAnagrams(strs));

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] key = new int[26];
            for (int j = 0; j < str.length(); j++) {
                key[str.charAt(j)-'a']++;
            }
            String s = Arrays.toString(key);
            map.computeIfAbsent(s, k -> new ArrayList<>());
            map.get(s).add(str);
        }
        List<List<String>> lists = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry:map.entrySet()){
            lists.add(entry.getValue());
        }
        return lists;
    }
}
