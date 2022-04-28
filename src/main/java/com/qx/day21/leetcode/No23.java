package com.qx.day21.leetcode;

import com.qx.day21.list.ListBuild;
import com.qx.day21.list.ListNode;
import com.qx.day21.list.ListUtil;

/**
 * User: xuan
 * Date: 2021/9/28
 * Time: 19:09
 */
public class No23 {

    public static void main(String[] args) {
        ListNode l1 = ListBuild.createList(new int[]{1,3,5,7});
        ListNode l2 = ListBuild.createList(new int[]{2,4,6,8});
        ListNode l3 = ListBuild.createList(new int[]{0,3,5,9});
        ListNode[] l = new ListNode[] {l1,l2,l3};
        ListUtil.order(mergeKLists(l));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length<1){
            return null;
        }
        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++) {
            res = merge2Lists(res,lists[i]);
        }
        return res;
    }

    public static ListNode merge2Lists(ListNode l1,ListNode l2){
        ListNode node = new ListNode();
        ListNode root = node;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                node.next = l1;
                l1 = l1.next;
            }else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if(l1==null){
            node.next = l2;
        }else {
            node.next = l1;
        }
        return root.next;
    }
}
