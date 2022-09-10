package com.qx.zhenti.tencent.music.shixi2022;

import com.qx.shuati.tree.TreeNode;

import java.util.ArrayList;

/**
 * @author xuan
 * @date 2022/6/17 14:51
 */
public class No5 {

    public TreeNode xorTree (TreeNode root, ArrayList<ArrayList<Integer>> op) {
        // write code here
        TreeNode ans = new TreeNode(0);

        init(root,ans);

        for (ArrayList<Integer> list : op) {
            dfs(root, ans, list, false);
        }
        return ans;
    }

    public void dfs(TreeNode root,TreeNode ans,ArrayList<Integer> list,boolean flag){
        if(root==null){
            return;
        }
        if(root.val==list.get(0)){
            flag = true;
        }
        if(flag){
            ans.val ^= list.get(1);
        }
        dfs(root.left,ans.left,list,flag);
        dfs(root.right,ans.right,list,flag);
    }

    public void init(TreeNode root,TreeNode ans){
        if(root==null){
            return;
        }
        if(root.left!=null){
            ans.left = new TreeNode(0);
            init(root.left,ans.left);
        }
        if(root.right!=null){
            ans.right = new TreeNode(0);
            init(root.right,ans.right);
        }
    }
}
