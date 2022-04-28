package com.qx.day21.leetcode;



import com.qx.day21.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xuan
 * Date: 2022/3/21
 * Time: 14:22
 */
public class No653 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        System.out.println(list.get(0));



    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        int l = 0;
        dfs(root,list);
        int r = list.size()-1;

        while(l<r){
            if(list.get(l)+list.get(r)==k){
                return true;
            }else if(list.get(l)+list.get(r)<k){
                l++;
            }else{
                r--;
            }
        }
        return false;
    }
    void dfs(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }
}
