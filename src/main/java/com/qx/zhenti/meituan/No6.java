package com.qx.zhenti.meituan;

import java.util.Scanner;

/**
 * @author Xuan
 * Date: 2021/12/21
 * Time: 16:43
 */
public class No6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int left = 0;
        int right = 0;
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if (c == 'T') {
                if (flag) {
                    left = i;
                    break;
                }
            } else if (c == 'M') {
                flag = true;
            }
        }
        flag = false;
        for (int i = len - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if (c == 'M') {
                if (flag) {
                    right = i;
                    break;
                }
            } else if (c == 'T') {
                flag = true;
            }
        }
        System.out.println(input.substring(left + 1, right));
    }


}
