package com.qx.bishi.qwe;

import java.util.*;

/**
 * @author xuan
 * @date 2022/8/18 19:38
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] in = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] out = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if(in.length==0){
            System.out.println("false");
            return;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0,j=0; i <in.length; i++) {
            stack.push(in[i]);
            while (j<out.length&&in[j]==stack.peek()){
                stack.pop();
                j++;
            }
        }
        System.out.println(stack.isEmpty());
    }

}
