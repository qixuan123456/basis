package com.qx.shuati.tencent.music.shixi2022;

import com.qx.day21.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xuan
 * @date 2022/6/17 13:58
 */
public class No4 {

    public ArrayList<TreeNode> deleteLevel (TreeNode root, ArrayList<Integer> a) {
        // write code here
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<TreeNode> ans = new ArrayList<>();
        int n = a.size();
        int index = 0;
        int c = 0;

        a.sort(Integer::compare);
        queue.add(root);
        if(a.get(index)-1!=c){
            ans.add(root);
        }
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }

                if(index<n&&c+1==a.get(index)-1){
                    node.left = null;
                    node.right = null;
                }

                if(index<n&&c==a.get(index)-1&&((index+1>=n||index+1<n&&c+1!=a.get(index+1)-1))){
                    if(node.left!=null){
                        ans.add(node.left);
                    }
                    if(node.right!=null){
                        ans.add(node.right);
                    }
                }
            }
            if(index<n&&c==a.get(index)-1){
                index++;
            }
            c++;
        }

        return ans;
    }
}
