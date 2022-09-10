package com.qx.shuati.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User: xuan
 * Date: 2021/9/19
 * Time: 16:26
 */
public class TreeUtil {

    /**
     * 前序遍历
     * @param root 根节点
     */
    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "\t");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 中序遍历
     * @param root 根节点
     */
    public static void minOrder(TreeNode root) {
        if (root != null) {
            minOrder(root.left);
            System.out.print(root.val + "\t");
            minOrder(root.right);
        }
    }
    /**
     * 后序遍历
     * @param root 根节点
     */
    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + "\t");
        }
    }

    /**
     * 水平遍历
     * @param root 根节点
     */
    public static void levelOrder(TreeNode root) {
        if(root==null){
            return;
        }
        //创建队列，将root加入，建立第一层
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //遍历每一层节点的同时将下一层节点放进队列
        while(!queue.isEmpty()){
            int size = queue.size();
            //遍历上层节点，拓展队列，将下层节点加到队列
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                System.out.print(node.val+"\t");
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            //将第x层遍历list放进最终大的list
        }
    }


    /**
     * 最大深度
     * @param root 根节点
     * @return 最大深度
     */
    public static int depthForTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depthForTree(root.left), depthForTree(root.right)) + 1;
    }

    /**
     * 查找子树中目标节点的父节点
     * @param root  根结点
     * @param node  目标节点
     * @return node的父节点
     */
    public static TreeNode getParentNode(TreeNode root, TreeNode node) {
        //当前结点为null， 直接返回，函数出口
        if (root == null) {
            return null;
        }
        //当前结点的左孩子或右孩子是目标节点，则代表当前结点是目标结点的父结点，函数出口
        if (root.left == node || root.right == node) {
            return root;
        }
        //否则递归，先递归左子树
        TreeNode result = getParentNode(root.left, node);
        //如果左递归没有发现符合条件，既result == null时，才开始右递归，如果已经发现了就不右递归了，直接返回结果
        if (result == null) {
            result = getParentNode(root.right, node);
        }
        return result;
    }
}
