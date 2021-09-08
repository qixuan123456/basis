package Test.Stack;

import java.util.Stack;

public class MinStack {
    public Stack<Integer> stack1;
    public Stack<Integer> stack2;
    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.add(x);
        if(stack2.empty()||stack2.peek()>=x)
            stack2.add(x);
    }

    public void pop() {
        if(stack1.peek().equals(stack2.peek())){
            stack1.pop();
            stack2.pop();
        }
        else {
            stack1.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println( minStack.min());
        minStack.pop();
        System.out.println( minStack.top());
        System.out.println(minStack.min());

    }
}
