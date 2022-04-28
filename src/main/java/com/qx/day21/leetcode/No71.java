package com.qx.day21.leetcode;

import java.util.*;

/**
 * @author Xuan
 * Date: 2022/1/6
 * Time: 18:48
 */
public class No71 {

    public static void main(String[] args) {
        System.out.println("asfa////sdasdf");
        System.out.println(simplifyPath("//"));
    }

    public static String simplifyPath(String path) {
        String[] p = path.split("//*");
        if(p.length==0){
            return "/";
        }
        Deque<String> stack = new ArrayDeque<>();
        int i = 0;
        if("".equals(p[0]))i++;
        for (;i<p.length;i++) {
            System.out.println(p[i]);
            if(".".equals(p[i])){
            }
            else if("src/main".equals(p[i])){
                if(!stack.isEmpty())
                    stack.removeLast();
            }else {
                stack.addLast("/"+p[i]);
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.removeFirst());
        }
        return sb.toString();
    }
}
