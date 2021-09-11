package test.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(queue1.isEmpty()){
            queue2.add(x);
        }
        else {
            queue1.add(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(queue1.isEmpty()){
            while(queue2.size()>1){
                queue1.add(queue2.poll());
            }
            return queue2.remove();
        }
        else {
            while(queue1.size()>1){
                queue2.add(queue1.poll());
            }
            return queue1.remove();
        }
    }

    /** Get the top element. */
    public int top() {
        if(queue1.isEmpty()){
            while(queue2.size()>1){
                queue1.add(queue2.poll());
            }
            int a = queue2.element();
            queue1.add(queue2.poll());
            return a;
        }
        else {
            while(queue1.size()>1){
                queue2.add(queue1.poll());
            }
            int a = queue1.element();
            queue2.add(queue1.poll());
            return a;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty()&&queue2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
