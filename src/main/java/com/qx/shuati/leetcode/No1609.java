package com.qx.shuati.leetcode;


import com.qx.shuati.tree.TreeBuilder;
import com.qx.shuati.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Xuan
 * Date: 2021/12/25
 * Time: 18:58
 */
public class No1609 {
    public static void main(String[] args) {

        Integer[] integers = new Integer[]{1,10,4,3,null,7,9,12,8,6,null,null,2};

        TreeNode root = TreeBuilder.create().createTree(integers);
        System.out.println(isEvenOddTree(root));
    }

    public static boolean isEvenOddTree(TreeNode root) {
        if(root.val%2==0){
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        boolean flag = false;
        queue1.add(root);
        while (!queue1.isEmpty()){
            TreeNode node = queue1.poll();
            if(node.left!=null){
                list.add(node.left);
            }
            if(node.right!=null){
                list.add(node.right);
            }
            if(queue1.isEmpty()){
                if(!judge(list,flag)){
                    return false;
                }
                queue1.addAll(list);
                list.clear();
                flag = !flag;
            }
        }
        return true;
    }

    public static boolean judge(List<TreeNode> list,boolean flag){
        if(flag){
            for (int i = 0; i < list.size(); i++) {
                TreeNode node = list.get(i);
                if(node.val%2!=1){
                    return false;
                }
                if(i>0&&node.val<=list.get(i-1).val){
                    return false;
                }
            }
        }else {
            for (int i = 0; i < list.size(); i++) {
                TreeNode node = list.get(i);
                if(node.val%2!=0){
                    return false;
                }
                if(i>0&&node.val>=list.get(i-1).val){
                    return false;
                }
            }
        }
        return true;
    }
}
