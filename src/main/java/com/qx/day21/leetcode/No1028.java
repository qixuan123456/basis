package com.qx.day21.leetcode;



import com.qx.day21.tree.TreeNode;
import com.qx.day21.tree.TreeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xuan
 * Date: 2022/3/21
 * Time: 16:56
 */
public class No1028 {
    public static void main(String[] args) {
        String s = "13-401--349---90--88";
        TreeNode treeNode = new No1028().recoverFromPreorder(s);
        TreeUtil.levelOrder(treeNode);
    }

    public TreeNode recoverFromPreorder(String traversal) {
        char[] chars = traversal.toCharArray();
        int i = 0;
        int length = chars.length;
        int val = 0;
        Map<Integer, TreeNode> map = new HashMap<>();

        while(i<length&&chars[i]!='-'){
            val = val*10+(chars[i]-'0');
            i++;
        }
        TreeNode root = new TreeNode(val);
        map.put(0, root);
        while (i < length) {
            int len = 0;
            while (i < length && chars[i] == '-') {
                len++;
                i++;
            }
            val = 0;
            while(i<length&&chars[i]!='-'){
                val = val*10+(chars[i]-'0');
                i++;
            }
            TreeNode newNode = new TreeNode(val);
            TreeNode parent = map.get(len - 1);
            if(parent.left==null){
                parent.left = newNode;
            }else {
                parent.right = newNode;
            }
            map.put(len, newNode);
        }
        return root;
    }
}
