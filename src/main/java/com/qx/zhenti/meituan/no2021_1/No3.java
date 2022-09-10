package com.qx.zhenti.meituan.no2021_1;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/6/29 15:43
 */
public class No3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int value = 0;
        int shiji = 0;
        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            value +=Math.max(a,b);
            shiji += (b>a?0:(a-b));
        }

        System.out.println(value+" "+shiji);
    }
}
