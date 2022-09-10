package com.qx.bishi.jingdong;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/27 19:38
 */
public class No2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
            } else {
                map2.put(nums[i], map2.getOrDefault(nums[i], 0) + 1);
            }
        }
        int[][] a1 = new int[2][2];
        int[][] a2 = new int[2][2];
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (entry.getValue() >= a1[0][1]) {
                a1[0][0] = entry.getKey();
                a1[0][1] = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            if (entry.getValue() >= a2[0][1]) {
                a2[0][0] = entry.getKey();
                a2[0][1] = entry.getValue();
            }
        }


        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (entry.getKey() != a1[0][0] && entry.getValue() >= a1[1][1]) {
                a1[1][0] = entry.getKey();
                a1[1][1] = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            if (entry.getKey() != a2[0][0] && entry.getValue() >= a2[1][1]) {
                a2[1][0] = entry.getKey();
                a2[1][1] = entry.getValue();
            }
        }

        if (a1[0][0] == a2[0][0]) {
            System.out.println(n - Math.max(a1[0][1] + a2[1][1], a1[1][1] + a2[0][1]));
        } else {
            System.out.println(n - a1[0][1] - a2[0][1]);
        }
    }
}
