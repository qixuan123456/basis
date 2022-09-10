package com.qx.help.xiaosi;


import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/20 10:55
 */
//烤串
public class No1 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = Integer.parseInt(scanner.nextLine());
//
//        char[] s1 = scanner.nextLine().toCharArray();
//        char[] s2 = scanner.nextLine().toCharArray();
//        char[] ans = new char[2*n];
//        int index = 0;
//        for (int i = 0; i < n; i++) {
//            ans[index++] = s1[i];
//            ans[index++] = s2[i];
//        }
//        System.out.println(new String(ans));
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        System.out.println(a);
        System.out.println(a.length());
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 100000; i++) {
            stringBuilder.append('a');
        }
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.length());
    }
}
