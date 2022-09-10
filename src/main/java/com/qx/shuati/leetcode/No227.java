package com.qx.shuati.leetcode;

import java.util.Stack;

/**
 * @author xuan
 * @date 2022/7/30 14:00
 */
public class No227 {
    public static void main(String[] args) {
        System.out.println(calculate("3-2+2"));
    }
    public static int calculate(String s) {
        s = s.replace(" ", "");
        Stack<Integer> stack = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for (int i = 0; i < s.length(); ) {
            int num = 0;
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                operator.push(c);
                i++;
            } else {
                while (i<s.length()&&Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                if(operator.isEmpty()){
                    stack.push(num);
                    continue;
                }
                char o = operator.peek();
                if (o != '*' && o != '/') {
                    stack.push(num);
                } else {
                    operator.pop();
                    int a = stack.pop();
                    if (o == '*') {
                        stack.push(a * num);
                    } else {
                        stack.push(a * num);
                    }
                }
            }
        }
        int ans = 0;
        while (!stack.isEmpty()&&!operator.isEmpty()) {
            char o = operator.pop();
            int num = stack.pop();
            if(o=='+'){
                ans = num+ans;
            }else {
                ans = ans-num;
            }
        }
        return stack.pop()+ans;
    }
}
