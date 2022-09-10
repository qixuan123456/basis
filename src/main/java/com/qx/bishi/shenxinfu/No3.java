package com.qx.bishi.shenxinfu;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author xuan
 * @date 2022/9/1 20:10
 */
public class No3 {

    public static void main(String[] args) {
        System.out.println(get_substr("A2C11222122BCC111CCAAAB"));
    }

    public static String get_substr(String st) {
        // write code here
        char[] chars = st.toCharArray();
        Deque<int[]> stack = new LinkedList<>();
        for (int i = 0; i < st.length(); i++) {
            if (stack.isEmpty()) {
                stack.addLast(new int[]{chars[i], 1});
                continue;
            }

            int[] peek = stack.peekLast();
            if (peek[0] == chars[i]) {
                peek[1]++;
            } else {
                if (peek[1] >= 3) {
                    stack.pollLast();
                    if(!stack.isEmpty()){
                        peek = stack.peekLast();
                        if (peek[0] == chars[i]) {
                            peek[1]++;
                        }else{
                            stack.addLast(new int[]{chars[i], 1});
                        }
                    }else {
                        stack.addLast(new int[]{chars[i], 1});
                    }
                    continue;
                }
                stack.addLast(new int[]{chars[i], 1});
            }


        }
        if(!stack.isEmpty()){
            int[] peek = stack.peekLast();
            if(peek[1]>=3){
                stack.pollLast();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int[] poll = stack.pollLast();

            for (int i = 0; i < poll[1]; i++) {
                sb.append((char) (poll[0]));
            }
        }
        return sb.toString();
    }
}
