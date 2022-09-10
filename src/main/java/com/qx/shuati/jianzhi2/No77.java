package com.qx.shuati.jianzhi2;

import com.qx.shuati.list.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author xuan
 * @date 2022/4/20 15:25
 */
public class No77 {
    public static void main(String[] args) {

    }

    public static ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        ListNode node = head;
        while(node!=null){
            queue.offer(node);
            node = node.next;
        }
        node = new ListNode(10);
        head = node;
        while (!queue.isEmpty()){
            node.next = queue.poll();
            node.next.next = null;
            node = node.next;
        }

        return head.next;
    }
}
