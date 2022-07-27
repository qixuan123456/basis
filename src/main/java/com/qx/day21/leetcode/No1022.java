package com.qx.day21.leetcode;

import com.qx.day21.tree.TreeNode;

/**
 * @author xuan
 * @date 2022/5/30 15:46
 */
public class No1022 {


    private int ans = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root,0);
        return ans;
    }

    public void dfs(TreeNode root,int current){
        if(root==null){
            return;
        }
        current = current*2+root.val;
        if(root.left==null&&root.right==null){
            ans+=current;
            return;
        }
        dfs(root.left,current);
        dfs(root.right,current);
    }

    public static void main(String[] args) {

    }

}
