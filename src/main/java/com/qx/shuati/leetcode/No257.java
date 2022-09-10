package com.qx.shuati.leetcode;



import com.qx.shuati.tree.TreeBuilder;
import com.qx.shuati.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: xuan
 * Date: 2021/10/22
 * Time: 15:02
 */
public class No257 {
    public static void main(String[] args) {
        No257 no257 = new No257();
        TreeBuilder tb = new TreeBuilder();
        TreeNode root = tb.createTree(new Integer[]{37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8});
        System.out.println(no257.binaryTreePaths(root));
    }
    public List<String> list = new ArrayList<>();
    public List<Integer> la = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return list;
    }
    public boolean dfs(TreeNode root){
        if(root==null){
            return false ;
        }
        la.add(root.val);
        if(root.left==null&&root.right==null){
            list.add(toString());
        }
        if(dfs(root.left)){
            la.remove(la.size()-1);
        }

        if(dfs(root.right)){
            la.remove(la.size()-1);
        }
        return true;
    }

    public String toString() {
        if(la.size()==0){
            return "";
        }
        StringBuilder s = new StringBuilder();
        s.append(la.get(0));
        for (int i = 1; i < la.size(); i++) {
            s.append("->");
            s.append(la.get(i));
        }
        return s.toString();
    }
}
