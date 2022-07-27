package com.qx.shuati.Shopee.sre_2022;

import java.util.Stack;

/**
 * @author xuan
 * @date 2022/7/19 16:15
 */
public class No2 {

    public String Paired69 (String S) {
        // write code here

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(c=='6'){
                stack.push(c);
                sb.append(c);
            }else {
                if(!stack.isEmpty()){
                    if(stack.peek()=='6'){
                        stack.pop();
                        sb.append(c);
                    }else {
                        stack.push(c);
                    }
                }else {
                    sb.insert(0,6);
                    sb.append(c);
                }
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            sb.append('9');
        }
        return sb.toString();
    }
}
