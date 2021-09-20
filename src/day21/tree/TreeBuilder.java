package day21.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * User: xuan
 * Date: 2021/9/19
 * Time: 16:11
 */
public class TreeBuilder {

    public TreeBuilder(){

    }
    public TreeNode createTree(int[] array){
        List<TreeNode> nodeList = new LinkedList<TreeNode>();
        for (int j : array) nodeList.add(new TreeNode(j));
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
        }
        int lastparentIndex = array.length / 2 - 1;
        nodeList.get(lastparentIndex).left = nodeList
                .get(lastparentIndex * 2 + 1);
        if (array.length % 2 == 1)
            nodeList.get(lastparentIndex).right = nodeList
                    .get(lastparentIndex * 2 + 2);
        return nodeList.get(0)==null?null:nodeList.get(0);
    }

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

}
