package com.qx.shuati.leetcode;

import com.qx.shuati.tree.TreeNode;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2022/8/20 10:04
 */
public class No654 {

    public static void main(String[] args) {

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int start, int end) {
        if(start>end){
            return null;
        }
        int index = search(nums, start, end);

        TreeNode node = new TreeNode(nums[index]);
        node.left = dfs(nums,start,index-1);
        node.right = dfs(nums,index+1,end);
        return node;
    }

    public int search(int[] nums, int start, int end) {
        int res = start;
        int num = nums[start];

        for (int i = start + 1; i <= end; i++) {
            if (nums[i]>num){
                num = nums[i];
                res = i;
            }
        }
        return res;
    }
}
