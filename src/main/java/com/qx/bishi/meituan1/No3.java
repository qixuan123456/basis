package com.qx.bishi.meituan1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/13 16:22
 */
// 82%
public class No3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = n - 1; i >= 0; i--) {
            queue.addFirst(nums[i]);
            queue.addFirst(queue.pollLast());
            queue.addFirst(queue.pollLast());
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            if(i==0){
                System.out.print(queue.pollFirst());
            }else {
                System.out.print(" " + queue.pollFirst());
            }
        }
    }
}
