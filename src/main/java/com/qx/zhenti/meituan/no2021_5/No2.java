package com.qx.zhenti.meituan.no2021_5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/14 15:12
 */
public class No2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] ints = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = ans ^ ints[i];
        }

        int[] temp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            temp[i] = temp[i-1]^i;
        }

        for (int i = 2; i <= n; i++) {
            ans ^= temp[n%i];
            if(n/i%2!=0){
                ans ^= temp[i-1];
            }
        }
        System.out.println(ans);
    }
}
