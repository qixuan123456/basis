package com.qx.day21.leetcode;

import java.util.*;

/**
 * @author Xuan
 * Date: 2022/4/11
 * Time: 15:45
 */
public class No30 {


    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        Map<String, Integer> allWords = new HashMap<>();

        for (String word : words) {
            allWords.put(word, allWords.getOrDefault(word, 0) + 1);
        }
        int wordLength = words[0].length();
        int allLength = wordLength * words.length;
        for (int i = 0; i < s.length() - allLength + 1; i++) {

            Map<String, Integer> haveWords = new HashMap<>();
            boolean flag = true;
            for (int j = 0; j < words.length; j++) {
                String substring = s.substring(i + j * wordLength, i + j * wordLength + wordLength);
                if (!allWords.containsKey(substring)) {
                    flag = false;
                    break;
                }
                haveWords.put(substring, haveWords.getOrDefault(substring, 0) + 1);
                if (haveWords.get(substring) > allWords.get(substring)) {
                    flag = false;
                    break;
                }
            }
            if (flag && haveWords.size() == allWords.size()) {
                res.add(i);
            }
        }
        return res;
    }
}
