package Day16.leetcode;

public class leet2 {

    public static ListNode gouzao(int a){

        ListNode node = new ListNode();
        ListNode node1 = node;
        if(a!=0){
            node.val=(a%10);
            a=a/10;
        }

        while(a!=0){
            node.next =new ListNode(a%10);
            node = node.next;
            a=a/10;
        }
        return node1;
    }

    public static long bianli(ListNode l){
        int i = 1;
        int num = 0;
        while(l!=null){

            num = num + (i*l.val);
            l = l.next;
            i=i*10;
            System.out.println(num);
        }

        return num;
    }
    public static void main(String[] args) {
        long c = 10000000000L;
        ListNode a = gouzao(12345);
//        while(a!=null){
//            System.out.println(a.val);
//            a=a.next;
//        }
        System.out.println(bianli(a));
    }

}
