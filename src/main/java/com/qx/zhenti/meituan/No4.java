package com.qx.zhenti.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Xuan
 * Date: 2021/12/20
 * Time: 20:43
 */
public class No4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        int[] A = new int[m];
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            A[i] = scanner.nextInt();
        }
        Arrays.fill(B, -1);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            if (scanner.nextInt() == 2) {
                System.out.println(B[scanner.nextInt()-1]);
            } else {
                int k = scanner.nextInt();
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                for (int j = x; (j - x) < k && j <= m && y <= m; j++) {
                    B[y-1] = A[j-1];
                    y++;
                }
            }
        }
    }


}
