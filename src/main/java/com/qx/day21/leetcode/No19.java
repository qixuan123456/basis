package com.qx.day21.leetcode;


import com.qx.day21.list.ListBuild;
import com.qx.day21.list.ListNode;
import com.qx.day21.list.ListUtil;

/**
 * User: xuan
 * Date: 2021/9/28
 * Time: 13:44
 */
public class No19 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int n = 4;
        ListNode root = ListBuild.createList(arr);
        ListUtil.order(removeNthFromEnd(root,n));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==0){
            return head;
        }
        ListNode pre = head;
        int a =order(pre,n);
        if(a==n){
            head = head.next;
        }
        return head;
    }

    public static int order(ListNode head ,int n){
        if(head==null){
            return 0;
        }
        int a = order(head.next, n)+1;
        if(a==n+1){
            head.next = head.next.next;
        }
        return a;
    }
}
