package com.qx.bishi;

import com.qx.day21.list.ListNode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author xuan
 * @date 2022/4/24 19:39
 */
public class No1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long money = sc.nextInt();

        long[] day = new long[n];

        for (int i = 0; i < n; i++) {
            day[i] = sc.nextInt();
        }
        int geshu = 0;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            if(i!=n-1&&day[i]>day[i+1]){
                int left = i-1,right =i;
                while(left>=pre&&day[left]<day[right]){
                    left--;
                }
                left++;
                Arrays.sort(day,left,right);
                for (int j = left; j < right; j++) {
                    if(money>=day[left]){
                        money-=day[j];
                        geshu++;
                    }
                }
                money+=geshu*day[right];
                geshu = 0;
                if(i!=0&&day[i-1]<day[i]){
                    pre = right;
                }
            }
            if(i==n-1){
                if(day[i]>day[i-1]){
                    int left = i-1,right =i;
                    while(left>=pre&&day[left]<day[right]){
                        left--;
                    }
                    left++;
                    Arrays.sort(day,left,right);
                    for (int j = left; j < right; j++) {
                        if(money>=day[left]){
                            money-=day[j];
                            geshu++;
                        }
                    }
                    money+=geshu*day[right];
                }
            }

        }
        System.out.println(money);







//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//        char[] chars = new char[n];
//        chars = sc.nextLine().toCharArray();
//        long right = 0;
//        int left = 0;
//        for (int i = 0; i < n; i++) {
//            if(chars[i]=='1'){
//                right+=(i+1);
//            }
//        }
//        long ans = right;
//        for (int i = 0; i < n; i++) {
//            if(chars[i]=='1'){
//                right -=(i+1);
//            }else {
//                left +=(i+1);
//            }
//            ans = Math.min(ans,Math.abs(right-left));
//        }
//        System.out.println(ans);








//        int[] a = {1,2,3,4};
//        System.out.println(getNumber(a));




//        Scanner sc = new Scanner(System.in);
//        int n = Integer.parseInt(sc.nextLine());
//        char[][] chars = new char[n][];
//        for (int i = 0; i < n; i++) {
//            chars[i] = sc.nextLine().toCharArray();
//        }
//        int len = chars[0].length;
//        int[] ans = new int[len];
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < n; j++) {
//                ans[i] = ans[i]*10+chars[j][i]-'0';
//            }
//        }
//        Arrays.sort(ans);
//        for (int i = 0; i < len; i++) {
//            System.out.println(ans[i]);
//        }
    }

    public static int getNumber (int[] a) {
        // write code here
        List<Integer> list = new ArrayList<>();
        for (int j : a) {
            list.add(j);
        }
        while (list.size()>1){
            for (int i = list.size()-1; i >= 0; i--) {
                if(!is(i+1)){
                    list.remove(i);
                }
            }
        }
        return list.get(0);

    }
    public static boolean is(int num){
        if(num==1) {
            return false;
        }
        double d = Math.sqrt(num);

        for (int i = 2; i <= d; i++) {
            if(num%i==0){
                return false;
            }
        }
        return true;
    }


    public ListNode solve (ListNode[] a) {
        // write code here
        ListNode ans = a[0];
        Set<ListNode> set = new HashSet<>();
        for(int i=0;i<a.length;i++){
            ListNode head = a[i];
            while(head!=null){
                if(!set.contains(head)){
                    set.add(head);
                    if(ans.val>head.val){
                        ans = head;
                    }
                }
                head = head.next;
            }
        }
        return ans;
    }
}
