package com.qx.day21.leetcode;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @author Xuan
 * Date: 2021/11/23
 * Time: 20:44
 */
public class No150 {
    public static void main(String[] args) {

        No150 no150 = new No150();
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(no150.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Pattern pattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
        for (String token : tokens) {
            if (pattern.matcher(token).matches()) {
                stack.push(token);
            } else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int c = 0;
                switch (token) {
                    case "+":
                        c = b + a;
                        break;
                    case "-":
                        c = b - a;
                        break;
                    case "*":
                        c = b * a;
                        break;
                    case "/":
                        c = b / a;
                        break;
                    default:
                        break;
                }
                stack.push(String.valueOf(c));
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
