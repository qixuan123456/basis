package com.qx.zhenti.zijietiaodong.kehuduan2017;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/9/4 14:58
 */
public class No1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int len = scanner.nextInt();
            sb.insert(start+len,new StringBuilder(sb.substring(start,start+len)).reverse());
        }
        System.out.println(sb);
    }
}
