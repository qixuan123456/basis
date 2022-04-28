package com.qx.day21.tree;

import static com.qx.day21.tree.TreeUtil.levelOrder;

/**
 * User: xuan
 * Date: 2021/9/20
 * Time: 20:09
 */
public class Test {
    public static void main(String[] args) {
        TreeBuilder treeBuilder = new TreeBuilder();
        TreeNode root = treeBuilder.createTree(new int[]{1,2,3,4,5,6,7});
        //水平遍历
        levelOrder(root);
        System.out.println();
        //前序遍历
        TreeUtil.preOrder(root);
        System.out.println();
        //中序遍历
        TreeUtil.minOrder(root);
        System.out.println();
        //后序遍历
        TreeUtil.postOrder(root);
        System.out.println();
        root = treeBuilder.createTree(new int[]{1,2,4,5,3,6,7},new int[]{4,2,5,1,6,3,7},1);
        levelOrder(root);
        System.out.println();
        root = treeBuilder.createTree(new int[]{4,2,5,1,6,3,7},new int[]{4,5,2,6,7,3,1},2);
        levelOrder(root);

    }
}
