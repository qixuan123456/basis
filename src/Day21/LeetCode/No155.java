package Day21.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        System.out.println(minStack.getMin());
    }
}
class MinStack {
    private List<Integer> list;
    private int min;

    /** initialize your data structure here. */
    public MinStack() {
        this.list=new ArrayList<>();
    }

    public void push(int val) {
        this.list.add(val);
        if(val<min){
            min=val;
        }
    }

    public void pop() {
        this.list.remove(list.size()-1);
        for(int i=0;i<list.size()-1;i++){
            if(min>list.get(i)){
                min=list.get(i);
            }
        }
    }

    public int top() {
        return this.list.get(list.size()-1);
    }

    public int getMin() {
        return min;
    }
}
