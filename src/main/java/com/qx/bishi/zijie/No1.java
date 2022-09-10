package com.qx.bishi.zijie;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/9/4 18:59
 */
public class No1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] parameter = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int n = parameter[0], minutes = parameter[1];
        int[] customer = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] smile = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int max = Integer.MIN_VALUE;
        if (minutes >= n) {
            System.out.println(Arrays.stream(customer).sum());
            return;
        }


        for (int i = 0; i < customer.length - minutes; i++) {
            int sum = 0;
            if (minutes == 0 && smile[i] == 1) {
                sum = parameter[i];
                max = Math.max(max, sum);
            } else if (minutes != 0) {
                for (int j = i; j < minutes + i; j++) {
                    sum += customer[j];
                }
                for (int j = i - 1; j >= 0; j--) {
                    if (smile[j] == 1) {
                        sum += customer[j];
                    }
                }

                for (int j = i + minutes; j < customer.length; j++) {
                    if (smile[j] == 1) {
                        sum += customer[j];
                    }
                }
                max = Math.max(sum, max);
            }
        }
        System.out.println(max);
    }
}
