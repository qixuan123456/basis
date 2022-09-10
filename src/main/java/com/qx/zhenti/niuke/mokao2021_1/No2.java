package com.qx.zhenti.niuke.mokao2021_1;

/**
 * @author xuan
 * @date 2022/7/15 18:36
 */
public class No2 {

    public static void main(String[] args) {
        System.out.println(NS_LIS("100"));
    }

    public static int NS_LIS (String n) {
        // write code here
        int c= 0;
        for (int i = 0; i < n.length(); i++) {
            c += n.charAt(i)-'0';
        }
        int b = n.charAt(0)-'0'-1;
        b += 9*(n.length()-1);
        return Math.max(b,c);
    }
}
