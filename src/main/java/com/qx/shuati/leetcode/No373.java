package com.qx.shuati.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Xuan
 * Date: 2022/1/14
 * Time: 20:53
 */
public class No373 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> nums1[o1[0]]+nums2[o1[1]]-nums1[o2[0]]-nums2[o2[1]]));
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            queue.add(new int[]{i,0});
        }
        while(k>0&&!queue.isEmpty()){
            int[] min = queue.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[min[0]]);
            list.add(nums2[min[1]]);
            lists.add(list);
            if(min[1]+1 < nums2.length){
                queue.add(new int[]{min[0],min[1]+1});
            }
        }
        return lists;
    }
}
