package com.qx.shuati.tree;


/**
 * User: xuan
 * Date: 2021/9/19
 * Time: 14:12
 */

public class TreeNode {
    
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
