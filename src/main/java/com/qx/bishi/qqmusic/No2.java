package com.qx.bishi.qqmusic;

import com.qx.shuati.tree.TreeBuilder;
import com.qx.shuati.tree.TreeNode;

/**
 * @author xuan
 * @date 2022/9/8 19:26
 */
public class No2 {

    static int mod = 1000000007;


    public static void main(String[] args) {
        TreeNode tree = TreeBuilder.create().createTree(new Integer[]{0,0,0,0,0,null,null,0,0,null,null,0,0});

        System.out.println(getTreeSum(tree));
    }


    public static int getTreeSum (TreeNode tree) {
        // write code here

        return (int)((Math.pow(2,dfs(tree))-1)%mod);
    }

    public static int dfs(TreeNode root){

        if(root==null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return Math.max(left,right)+1;
//        if(root==null){
//            return 0;
//        }
//
//        int left = dfs(root.left);
//        int right = dfs(root.right);
//        int res = (left+right)%mod;
//        if(left<right){
//            root.left.val = root.left.val+(right-left)%mod;
//        }else if(left>right){
//            root.right.val = root.right.val+(left-right)%mod;
//        }
//        root.val = 1;
//        res = (res%mod+Math.abs(right-left)%mod+1)%mod;
//        return res;
    }
}
