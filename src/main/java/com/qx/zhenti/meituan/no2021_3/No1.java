package com.qx.zhenti.meituan.no2021_3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/12 19:29
 */
public class No1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] a = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Arrays.stream(a).sum();
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < n; i++) {
            if (left <= b[i] - 1 && b[i] - 1 <= right) {
                max = 0;
                int sum = 0;
                int l = 0,r = 0;
                a[b[i] - 1] = 0;
                for (int j = 0; j < n; j++) {
                    if (a[j] == 0) {
                        sum = 0;
                    } else {
                        if (sum == 0) {
                            l = j;
                        }
                        sum += a[j];
                        r = j;
                        if(sum>max){
                            max = sum;
                            left = l;
                            right = r;
                        }
                    }
                }
                System.out.println(max);
            } else {
                a[b[i] - 1] = 0;
                System.out.println(max);
            }
        }
    }
}
