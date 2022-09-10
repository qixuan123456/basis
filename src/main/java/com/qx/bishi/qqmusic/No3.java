package com.qx.bishi.qqmusic;

import com.qx.shuati.tree.TreeNode;
import com.qx.test.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuan
 * @date 2022/9/8 20:18
 */
public class No3 {

    public static void main(String[] args) {
        ArrayList<Integer> preOrder = new ArrayList<>();
        ArrayList<Integer> inOrder = new ArrayList<>();

        preOrder.add(1);
        preOrder.add(1);
        preOrder.add(2);
        inOrder.add(1);
        inOrder.add(2);
        inOrder.add(1);
        System.out.println(getBinaryTrees(preOrder, inOrder));
    }
    public static ArrayList<TreeNode> getBinaryTrees(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        // write code here

        return dfs(preOrder,0,preOrder.size()-1,inOrder,0,inOrder.size()-1);

    }

    public static ArrayList<TreeNode> dfs(ArrayList<Integer> preOrder, int l1, int r1, ArrayList<Integer> inOrder, int l2, int r2) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if (l1 > r1) {
            return res;
        }
        if (l1 == r1) {
            res.add(new TreeNode(preOrder.get(l1)));
            return res;
        }

        for (int i = l2; i <= r2; i++) {
            if (preOrder.get(l1).equals(inOrder.get(i))) {

                List<TreeNode> left = dfs(preOrder, l1+1, r1+(l2-i), inOrder, l2, i);
                List<TreeNode> right = dfs(preOrder, r1+(l2-i)+1, r1, inOrder, i + 1, r2);
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        TreeNode root = new TreeNode(preOrder.get(l1));
                        root.left = left.get(j);
                        root.right = right.get(k);
                        res.add(root);
                    }
                }
                for (int j = 0; j < right.size(); j++) {
                    TreeNode root = new TreeNode(preOrder.get(l1));
                    root.right = right.get(j);
                    res.add(root);
                }
                for (int j = 0; j < left.size(); j++) {
                    TreeNode root = new TreeNode(preOrder.get(l1));
                    root.left = left.get(j);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
