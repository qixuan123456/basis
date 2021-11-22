package day21.leetcode;

import day21.tool.Util;
import day21.tree.TreeBuilder;
import day21.tree.TreeNode;
import day21.tree.TreeUtil;

/**
 * User: xuan
 * Date: 2021/10/14
 * Time: 15:08
 */
public class No1302 {
    public static void main(String[] args) {
        Integer[] a = {6,7,8,2,7,1,3,9,null,1,4,null,null,null,5};
        TreeBuilder treeBuilder = new TreeBuilder();
        TreeNode root = treeBuilder.createTree(a);
        No1302 no1302 = new No1302();
        System.out.println(no1302.deepestLeavesSum(root));

    }
//    public int deepestLeavesSum(TreeNode root) {
//        int depth = TreeUtil.depthForTree(root);
//        return d(root,depth);
//    }
//    public int d(TreeNode root,int depth){
//        if(root==null){
//            return 0;
//        }
//        if(depth==1){
//            return root.val;
//        }
//        return d(root.left,depth-1)+d(root.right, depth-1);
//    }
    public int maxDepth = 0;
    public int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        d(root,0);
        return sum;
    }

    public int d(TreeNode root,int depth){
        if(root==null){
            if(maxDepth<depth){
                maxDepth =depth;
                return -1;
            }
            if(maxDepth==depth){
                return 0;
            }
            return 1;
        }
        depth++;

        int left = d(root.left,depth);
        int right =d(root.right,depth);
        if(left==-1||right==-1){
            if(maxDepth<=depth) {
                sum = root.val;
                return 1;
            }
        }
        if(left==0&&right==0){
            if(maxDepth<=depth) {
                sum +=root.val;
            }
        }
        return 1;
    }
}
