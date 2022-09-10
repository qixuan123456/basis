package com.qx.shuati.leetcode;

import com.qx.shuati.tree.TreeBuilder;
import com.qx.shuati.tree.TreeNode;

/**
 * @author xuan
 * @date 2022/5/12 12:53
 */
public class No437 {


    public static void main(String[] args) {
        No437 no437 = new No437();
        TreeNode root = TreeBuilder.create().createTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        System.out.println(no437.pathSum(root,22));
    }
    public int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {

        dfs(root,targetSum,false);
        return ans;
    }

    public void dfs(TreeNode root, int targetSum, boolean flag){

        if(root==null){
            return;
        }
        if(root.val==8){
            System.out.println(root.val);
        }
        if(flag&&root.val!=targetSum){
            return;
        }
        if(root.val==targetSum){
            System.out.println(root.val);
            ans++;
        }
        dfs(root.right,targetSum-root.val,true);
        dfs(root.left,targetSum-root.val,true);
        dfs(root.left,targetSum,false);
        dfs(root.right,targetSum,false);



    }
}
