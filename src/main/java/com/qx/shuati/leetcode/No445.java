package com.qx.shuati.leetcode;

import com.qx.shuati.list.ListBuild;
import com.qx.shuati.list.ListNode;
import com.qx.shuati.list.ListUtil;

/**
 * @author xuan
 * @date 2022/5/27 10:45
 */
public class No445 {

    public static void main(String[] args) {
        No445 no445 = new No445();
        ListNode l1 = ListBuild.createList(new int[]{8,9,9});
        ListNode l2 = ListBuild.createList(new int[]{2});
        ListNode ans = no445.addTwoNumbers(l1,l2);
        ListUtil.order(ans);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1 = getLongth(l1);
        int length2 = getLongth(l2);
        ListNode newl = null;
        ListNode ans = null;
        if(l1.val==0){
            return l2;
        }
        if(l2.val==0){
            return l1;
        }
        if(length1>length2){
            newl = l2;
            while(length1>length2){
                ListNode last = new ListNode(0);
                last.next = newl;
                newl = last;
                length2++;
            }
            ans = add(newl,l1);

        }else if(length1<length2){
            newl = l1;
            while(length1<length2){
                ListNode last = new ListNode(0);
                last.next = newl;
                newl = last;
                length1++;
            }
            ans = add(newl,l2);
        }else{
            ans = add(l2,l1);
        }
        return (ans.val>0||(ans.val==0&&ans.next==null))?ans:ans.next;
    }

    public ListNode add(ListNode l1,ListNode l2){
        if(l1==null||l2==null){
            return new ListNode(0);
        }
        ListNode j = add(l1.next,l2.next);
        ListNode node = new ListNode((l1.val+l2.val+j.val)%10);
        node.next = j.next;
        ListNode jj = new ListNode((l1.val+l2.val+j.val)/10);
        jj.next = node;
        return jj;
    }

    public int getLongth(ListNode l1){
        if(l1 ==null){
            return 0;
        }
        return getLongth(l1.next)+1;
    }
}
