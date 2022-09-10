package com.qx.shuati.leetcode;

import java.util.*;

/**
 * @author xuan
 * @date 2022/8/19 23:10
 */
public class No127 {

    public static void main(String[] args) {

    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int ans = 2;
        while (!queue.isEmpty()&&!set.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                for (int j = 0; j < poll.length(); j++) {
                    StringBuilder sb = new StringBuilder(poll);
                    for (int k = 0; k < 26; k++) {
                        sb.setCharAt(j,(char) ('a'+k));
                        String ss = sb.toString();
                        if(ss.equals(endWord)){
                            return ans;
                        }
                        if(set.contains(ss)){
                            queue.add(ss);
                            set.remove(ss);
                        }
                    }
                }
            }
            ans++;
        }
        return 0;
    }
}
