package com.qx.shuati.list;

/**
 * User: xuan
 * Date: 2021/9/28
 * Time: 13:40
 */
public class ListTest {
    public static void main(String[] args) {
        ListNode root = ListBuild.createList(new int[]{1,5,4,3,2});
        ListUtil.order(root);
    }
}
