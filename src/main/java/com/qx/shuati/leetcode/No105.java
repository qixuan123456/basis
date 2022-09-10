package com.qx.shuati.leetcode;

import com.qx.shuati.tree.TreeNode;

/**
 * @author xuan
 * @date 2022/7/21 13:42
 */
public class No105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = preorder[preStart];
        for (int i = inStart; i <= inEnd; i++) {
            if (preorder[preStart] == inorder[i]) {
                node.left = buildTree(preorder, preStart + 1, preStart + i - inStart, inorder, inStart, i - 1);
                node.right = buildTree(preorder, preStart + i - inStart + 1, preEnd, inorder, i + 1, inEnd);
                break;
            }
        }
        return node;
    }
}
