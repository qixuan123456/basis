package day21.tree;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * User: xuan
 * Date: 2021/9/19
 * Time: 14:12
 */

public class TreeNode {
    
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
