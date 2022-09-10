package com.qx.shuati.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xuan
 * Date: 2022/4/9
 * Time: 21:17
 */
public class No780 {
    public static void main(String[] args) {
        System.out.println(reachingPoints(1,1,3,5));
    }

    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        Queue<int[]> queue = new LinkedList<>();
        int[] nums = {sx,sy};
        queue.offer(nums);
        while(!queue.isEmpty()){
            int[] a = queue.poll();
            if(a[0]==tx&&a[1]==ty){
                return true;
            }
            if(a[0]+a[1]<=tx){
                queue.add(new int[]{a[0]+a[1],a[1]});
            }
            if(a[0]+a[1]<=ty){
                queue.add(new int[]{a[0],a[0]+a[1]});
            }
        }
        return false;
    }
}
