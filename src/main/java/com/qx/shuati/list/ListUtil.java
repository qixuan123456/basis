package com.qx.shuati.list;

/**
 * User: xuan
 * Date: 2021/9/28
 * Time: 13:38
 */
public class ListUtil {

    public static void order(ListNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val+"\t");
        root = root.next;
        order(root);
    }
}
