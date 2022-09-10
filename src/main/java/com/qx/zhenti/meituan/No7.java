package com.qx.zhenti.meituan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author xuan
 * @date 2022/5/4 21:09
 */
public class No7 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] want = new int[N][N];
        int[] ans = new int[N];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                want[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!set.contains(want[i][j])) {
                    System.out.print(want[i][j]+" ");
                    set.add(want[i][j]);
                    break;
                }
            }
        }
    }
}
