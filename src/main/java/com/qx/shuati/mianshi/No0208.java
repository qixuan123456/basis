package com.qx.shuati.mianshi;

import com.qx.shuati.list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xuan
 * @date 2022/6/23 20:22
 */
public class No0208 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        while (head!=null){
            if(!set.add(head)){
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
