package com.qx.shuati.jingsai;

import com.qx.shuati.tree.TreeBuilder;
import com.qx.shuati.tree.TreeNode;
import org.junit.Test;

/**
 * @author xuan
 * @date 2022/5/8 19:25
 */
public class No292Test {
    No292 no292 = new No292();








    @Test
    public void averageOfSubtree(){
        Integer[] integer = new Integer[]{4,8,5,0,1,null,6};
        TreeNode tree = TreeBuilder.create().createTree(integer);
        System.out.println(no292.averageOfSubtree(tree));
    }

    @Test
    public void countTexts() {
        System.out.println(no292.countTexts("222222222222222222222222222222222222"));
    }

    @Test

    public void hasValidPath() {
        char[][] chars = {{'(','(','('},{')','(',')'},{'(','(',')'},{'(','(',')'}};
        System.out.println(no292.hasValidPath(chars));
    }

}
