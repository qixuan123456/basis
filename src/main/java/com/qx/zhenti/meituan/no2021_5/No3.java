package com.qx.zhenti.meituan.no2021_5;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author xuan
 * @date 2022/8/14 15:12
 */
public class No3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        Set<Integer> setQ = new HashSet<>();
        Set<Integer> setP = new HashSet<>();

        for (int i = 0; i < p; i++) {
            setP.add(scanner.nextInt());
        }

        for (int i = 0; i < q; i++) {
            setQ.add(scanner.nextInt());
        }
        setP.addAll(setQ);
        int sum = p + q - setP.size();
        System.out.print(p - sum);
        System.out.print(" " + (q - sum));
        System.out.print(" " + sum);
    }
}
