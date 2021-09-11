package test.stack;

import java.util.Stack;

public class SortedStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public SortedStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        if(stack1.empty()||val<stack1.peek()){
            stack1.add(val);
        }
        else{
            while(!stack1.empty()){
                if(stack1.peek()<val){
                    stack2.add(stack1.pop());
                }
                else{
                    break;
                }
            }
            stack1.add(val);
            while(!stack2.empty()){
                stack1.add(stack2.pop());
            }
        }
    }

    public void pop() {
        if(!isEmpty())
        stack1.pop();
    }

    public int peek() {
        return isEmpty()? -1:stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        SortedStack stack = new SortedStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
    }
}
