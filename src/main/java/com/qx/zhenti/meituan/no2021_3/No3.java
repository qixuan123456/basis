package com.qx.zhenti.meituan.no2021_3;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/12 18:56
 */
public class No3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            solution(scanner.nextLine());
        }

    }

    public static void solution(String s) {
        boolean shuzi = false;
        boolean zimu = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                if (i == 0) {
                    System.out.println("Wrong");
                    return;
                }
                shuzi = true;
            } else if (Character.isLowerCase(c)||Character.isUpperCase(c)) {
                zimu = true;
            } else {
                System.out.println("Wrong");
                return;
            }
        }
        if (shuzi && zimu) {
            System.out.println("Accept");
        }else {
            System.out.println("Wrong");
        }
    }
}
