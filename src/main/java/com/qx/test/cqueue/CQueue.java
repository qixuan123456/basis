package com.qx.test.cqueue;

import java.util.Stack;

public class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public CQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.add(stack1.pop());
            }
        }
        if(stack2.empty()){
            return -1;
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        CQueue c = new CQueue();
        System.out.println( c.deleteHead());
        c.appendTail(5);
        c.appendTail(2);
        System.out.println( c.deleteHead());
        System.out.println( c.deleteHead());
    }
}
