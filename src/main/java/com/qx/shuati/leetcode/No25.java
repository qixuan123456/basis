package com.qx.shuati.leetcode;


import com.qx.shuati.list.ListBuild;
import com.qx.shuati.list.ListNode;
import com.qx.shuati.list.ListUtil;

/**
 * @author Xuan
 * Date: 2022/3/19
 * Time: 17:04
 */
public class No25 {
    public static void main(String[] args) {
        ListNode head = ListBuild.createList(new int[]{1, 2, 3, 4, 5});
        ListNode listNode = new No25().reverseKGroup(head, 1);
        ListUtil.order(listNode);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = new ListNode(0);
        a.next = head;
        ListNode pre = a;

        ListNode tail = pre;
        while (head != null) {
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail != null) {
                    continue;
                }
                return a.next;
            }

            ListNode[] lists = reverse(head, tail);
            head = lists[1];
            tail = lists[0];
            pre.next = head;
            pre = tail;
            head = pre.next;

        }
        return a.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode a = tail.next;
        ListNode b = head;
        while (a != tail) {
            ListNode nextB = b.next;
            b.next = a;
            a = b;
            b = nextB;
        }
        return new ListNode[]{head, tail};
    }
}
