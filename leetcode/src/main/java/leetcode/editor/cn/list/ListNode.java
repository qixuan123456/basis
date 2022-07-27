package leetcode.editor.cn.list;

/**
 * User: xuan
 * Date: 2021/9/28
 * Time: 13:29
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
