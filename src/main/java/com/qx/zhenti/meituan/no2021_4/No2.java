package com.qx.zhenti.meituan.no2021_4;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/13 12:49
 */
public class No2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String s = scanner.nextLine();
        int start = 0;
        int end = 0;
        boolean T = false;
        boolean M = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'M') {
                M = true;
            }
            if (M && c == 'T') {
                start = i + 1;
                break;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == 'T') {
                T = true;
            }
            if (T && c == 'M') {
                end = i - 1;
                break;
            }
        }

        System.out.println(s.substring(start,end+1));

    }
}
