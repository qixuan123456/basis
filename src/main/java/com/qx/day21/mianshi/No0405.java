package com.qx.day21.mianshi;

import com.qx.day21.tree.TreeNode;

/**
 * @author xuan
 * @date 2022/6/23 20:43
 */
public class No0405 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }

    public boolean dfs(TreeNode root,long max,long min){
        if(root==null){
            return true;
        }
        if(root.val>=max||root.val<=min){
            return false;
        }

        return dfs(root.left,root.val,min)&&dfs(root.right,max,root.val);
    }
}
