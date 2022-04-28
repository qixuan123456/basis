package com.qx.day21.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xuan
 * @date 2022/4/21 16:18
 */
public class No1286 {
    public Queue<String> q = new LinkedList<>();
    public static void main(String[] args) {
        new No1286("abcd",2);
    }

    public No1286(String characters, int combinationLength) {
        char[] chars = characters.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        dfsInit(chars,0,stringBuilder,combinationLength);
    }

    public String next() {
        return q.poll();
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }

    public void dfsInit(char[] chars,int count,StringBuilder sb,int combinationLength){
        if(sb.length()==combinationLength){
            q.offer(sb.toString());
            return;
        }
        if(count>=chars.length){
            return;
        }
        for (int i = count; i < chars.length; i++) {
            sb.append(chars[i]);
            dfsInit(chars,i+1,sb,combinationLength);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
