package day21.list;

/**
 * User: xuan
 * Date: 2021/9/28
 * Time: 13:31
 */
public class ListBuild {
    public static ListNode createList(int[] arr){
        ListNode root = new ListNode();
        root.val = arr[0];
        ListNode node = root;
        for (int i = 1; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;

        }
        return root;
    }
}
