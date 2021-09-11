package test;

import day21.leetcode.TreeNode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTest {
    public static void main(String[] args) {

    }

    //层次遍历二叉树
    public static List<List<Integer>> cengcibianli(TreeNode root){
        Queue<TreeNode>  queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        queue.add(root);
        while(queue.peek()!=null){
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<len;i++){
                list.add(queue.element().val);
                if(queue.element().left!=null){
                    queue.add(queue.peek().left);
                }
                if(queue.element().right!=null){
                    queue.add(queue.peek().right);
                }
                queue.remove();
            }
            lists.add(list);
        }
        return lists;
    }

    //二叉树最大深度
    public int h=0;
    public void maximum_depth(TreeNode root, int depth){
        if(root==null){
            return;
        }
        h=Math.max(h,depth);
        maximum_depth(root.left,depth+1);
        maximum_depth(root.right,depth+1);
    }

    //二叉树是否对称
    public boolean isSymmetric(TreeNode root) {
        return isSame(root,root);
    }

    private boolean isSame(TreeNode node1,TreeNode node2) {
        if((node1==null&&node2!=null)||(node2==null&&node1!=null)){
            return false;
        }
        if(node1==null){
            return true;
        }
        return (node1.val== node2.val)&&isSame(node1.left,node2.right)&&isSame(node1.right,node2.left);
    }

    //二叉树路径和
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) {
            return false;
        }
        return isSome(root,targetSum,0);
    }
    public boolean isSome(TreeNode root,int targetSum,int sum){
        if(root!=null){
            if(root.right==null&&root.left==null){
                return sum+root.val==targetSum;
            }
            else if(root.right!=null&&root.left==null){
                return isSome(root.right,targetSum,sum+root.val);
            }
            else if(root.right==null){
                return isSome(root.left,targetSum,sum+root.val);
            }else {
                return isSome(root.right,targetSum,sum+root.val)
                        ||isSome(root.left,targetSum,sum+root.val);
            }
        }
        return targetSum==sum;
    }

}
