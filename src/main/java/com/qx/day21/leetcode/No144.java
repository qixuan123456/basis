package com.qx.day21.leetcode;


import com.qx.day21.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No144 {
    public List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {

        predo(root);
        return list;
    }
    public void predo(TreeNode root){
        if(root==null){
            return;
        }
        list.add(root.val);
        predo(root.left);
        predo(root.right);

    }
}
