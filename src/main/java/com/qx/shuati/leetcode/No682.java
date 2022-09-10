package com.qx.shuati.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Xuan
 * Date: 2022/3/26
 * Time: 16:31
 */
public class No682 {
    public static void main(String[] args) {
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        System.out.println(new No682().calPoints(ops));
        double a = 10.1;
        System.out.println(a==10);
    }

    public int calPoints(String[] ops) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        for(String s : ops){
            if("+".equals(s)){
                Integer a = stack.removeLast();
                int sum = stack.peekLast()+a;
                stack.addLast(a);
                stack.addLast(sum);
                ans+=sum;
            }else if("D".equals(s)){
                ans+=stack.peekLast()*2;
                stack.addLast(stack.peekLast()*2);
            }else if ("C".equals(s)){
                ans-=stack.removeLast();
            }else {
                int b = Integer.parseInt(s);
                stack.addLast(b);
                ans+=b;
            }
        }
        return ans;
    }


}
