package day21.leetcode;

import day21.list.ListBuild;
import day21.list.ListNode;
import day21.list.ListUtil;
import day21.tool.Util;

import java.util.Arrays;

/**
 * @author Xuan
 * Date: 2021/11/1
 * Time: 21:12
 */
public class No2058 {
    public static void main(String[] args) {
        No2058 no2058 = new No2058();
        ListNode listNode = ListBuild.createList(new int[]{5,4,3,2,1,1,2});
        ListUtil.order(listNode);
        System.out.println();
        Util.printArray(no2058.nodesBetweenCriticalPoints(listNode));
    }
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int min = -1;
        int max =-1;
        boolean flag = false;
        int[] aws = {-1,-1};
        ListNode preNode= head;
        head = head.next;
        while(head.next!=null){
            if((preNode.val>head.val&&head.val<head.next.val)||(preNode.val<head.val&&head.val>head.next.val)){
                if(aws[0]==-1){
                    aws[0] = min;
                    aws[1] = max;
                }
                aws[0] = Math.min(min,aws[0]);
                aws[1] = Math.max(max,aws[1]);
                min = 0;
                flag = true;

            }
            if(flag){
                min++;
                max++;
            }
            head = head.next;
            preNode = preNode.next;
        }
        if(aws[1]!=-1){
            aws[1]++;
        }
        return aws;
    }
}
