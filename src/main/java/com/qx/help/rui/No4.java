package com.qx.help.rui;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/9/3 11:16
 */
public class No4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int ans = Math.max(11,b+2)-a;
        System.out.println(ans);
    }
}
