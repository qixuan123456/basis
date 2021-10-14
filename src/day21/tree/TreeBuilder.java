package day21.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * User: xuan
 * Date: 2021/9/19
 * Time: 16:11
 */
public class TreeBuilder {

    public TreeBuilder(){

    }
    public static TreeBuilder create(){
        return new TreeBuilder();
    }
    /**
     * 水平创建二叉树
     * @param array 每个树节点的值
     * @return 根结点
     */
    public TreeNode createTree(int[] array){
        List<TreeNode> nodeList = new LinkedList<>();
        for (int j : array) nodeList.add(new TreeNode(j));
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
        }
        int lastParentIndex = array.length / 2 - 1;
        nodeList.get(lastParentIndex).left = nodeList
                .get(lastParentIndex * 2 + 1);
        if (array.length % 2 == 1)
            nodeList.get(lastParentIndex).right = nodeList
                    .get(lastParentIndex * 2 + 2);
        return nodeList.get(0)==null?null:nodeList.get(0);
    }

    /**
     * 创建二叉树
     * @param arr1 数组1
     * @param arr2 数组2
     * @param mode 1:根据前序与中序创建二叉树  2:根据中序和后序创建二叉树
     * @return 根节点
     */
    public TreeNode createTree(int[] arr1,int[] arr2,int mode){
        if(mode == 1){
            return createTreeByPreMid(arr1,arr2);
        }else if(mode==2) {
            return createTreeByMidPost(arr1,arr2);
        }else {
            System.out.println("Mode错误");
            return null;
        }
    }

    /**
     * 根据前序与中序创建二叉树
     * @param pre 前序数组
     * @param in  中序数组
     * @return  根节点
     */
    private TreeNode createTreeByPreMid(int[] pre ,int[] in){
        return createTreeByPreMid(pre,0,pre.length-1,in,0,in.length-1);
    }

    private TreeNode createTreeByPreMid(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
        if(preStart>preEnd || inStart > inEnd){ //到达边界条件时返回null
            return null;
        }
        TreeNode  treeNode =new TreeNode(pre[preStart]);   //新建一个TreeNode

        for(int i=inStart;i<=inEnd;i++){
            if(in[i] == pre[preStart]){    //在中序中找到根节点的位置，【依次】将先序序列和中序序列分成左右字树，分别构建左右子树。
                // 重构左子树，注意边界条件
                treeNode.left = createTreeByPreMid( pre, preStart+1,           preStart+i-inStart, in, inStart, i-1);
                // 重构右子树，注意边界条件
                treeNode.right = createTreeByPreMid(pre, preStart+i-inStart+1, preEnd,             in, i+1,     inEnd);
            }
        }
        return treeNode;
    }

    /**
     * 根据中序与后序创建二叉树
     * @param in   中序数组
     * @param last 后序数组
     * @return 根节点
     */
    private TreeNode createTreeByMidPost(int[] in,int[] last){
        return createTreeByMidPost(in,0,in.length-1,last,0,last.length-1);
    }

    private TreeNode createTreeByMidPost(int[] in,int inStart,int inEnd,int[] last,int lastStart,int lastEnd){
        if(inStart > inEnd || lastStart > lastEnd)
            return null;
        TreeNode treeNode = new TreeNode(last[lastEnd]);
        for(int i=inStart;i<=inEnd;i++){
            if(in[i] == last[lastEnd]){
                treeNode.left = createTreeByMidPost(in, inStart,    i-1,    last,   lastStart,              lastStart+i-inStart-1);
                treeNode.right = createTreeByMidPost(in,    i+1,    inEnd,  last,   lastStart+i-inStart,    lastEnd-1);
            }
        }
        return treeNode;
    }

    /**
     *
     * @param array 输入数组，可以缺少节点
     * @return 根结点
     */
    public TreeNode createTree(Integer[] array){

        if(array==null||array.length==0){
            return new TreeNode();
        }
        TreeNode root = new TreeNode();
        TreeNode treeNode;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        root.val = array[0];
        int i =1;
        while (queue.size()>0){
            treeNode = queue.poll();
            treeNode.left = array[i]==null?null:new TreeNode(array[i]);
            if(array[i]!=null) queue.add(treeNode.left);
            i++;
            if(i==array.length) return root;
            treeNode.right = array[i]==null?null:new TreeNode(array[i]);
            if(array[i]!=null) queue.add(treeNode.right);
            i++;
            if(i==array.length) return root;
        }
        return root;
    }


}
