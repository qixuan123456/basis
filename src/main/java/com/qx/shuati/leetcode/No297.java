package com.qx.shuati.leetcode;

import com.qx.shuati.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xuan
 * @date 2022/8/19 21:55
 */
public class No297 {

    static public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            sb.append(root.val);
            while (!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if(poll.left==null){
                        sb.append("+A");
                    }else {
                        queue.add(poll.left);
                        sb.append("+").append(poll.left.val);
                    }

                    if(poll.right==null){
                        sb.append("+A");
                    }else {
                        queue.add(poll.right);
                        sb.append("+").append(poll.right.val);
                    }
                }
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null) {
                return null;
            }
            String[] s = data.split("\\+");
            TreeNode node = new TreeNode(Integer.parseInt(s[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(node);
            int index = 1;
            while (!queue.isEmpty()){
                TreeNode poll = queue.poll();
                if(s[index].charAt(0)=='A'){
                    poll.left = null;
                }else {
                    poll.left = new TreeNode(Integer.parseInt(s[index]));
                    queue.add(poll.left);
                }
                index++;

                if(s[index].charAt(0)=='A'){
                    poll.right = null;
                }else {
                    poll.right = new TreeNode(Integer.parseInt(s[index]));
                    queue.add(poll.right);
                }
                index++;
            }
            return node;
        }
    }
}
