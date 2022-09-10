package com.qx.bishi.zijie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author xuan
 * @date 2022/9/4 19:03
 */
public class No3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Set<Integer> set = new HashSet<>();
            Set<Integer> set1 = new HashSet<>();
            for (int j = 0; j < n; j++) {
                set1.add(nums[i]);
            }
            for (int j = 0; j < n - 2; j++) {
                for (int k = j + 1; k < n - 1; k++) {
                    for (int l = k + 2; l < n; l++) {
                        set.add(nums[k] + nums[j] + nums[l]);
                    }
                }
            }
            if (set1.containsAll(set)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
