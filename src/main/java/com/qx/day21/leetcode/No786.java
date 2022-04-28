package com.qx.day21.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Xuan
 * Date: 2021/11/29
 * Time: 14:25
 */
public class No786 {

    public static void main(String[] args) {
        int[] arr = {1,7};
        No786 no786 = new No786();
        System.out.println(Arrays.toString(no786.kthSmallestPrimeFraction(arr,1)));
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->arr[a[0]]*arr[b[1]]-arr[a[1]]*arr[b[0]]);
        for (int i = 1; i < arr.length; i++) {
            queue.add(new int[]{0,i});
        }

        for (int i = 1; i < k; i++) {
            int[] res = queue.poll();
            if(res[0]+1<res[1]){
                queue.add(new int[]{res[0]+1,res[1]});
            }
        }
        int[] res = queue.poll();
        return new int[] {arr[res[0]],arr[res[1]]};
    }
}
