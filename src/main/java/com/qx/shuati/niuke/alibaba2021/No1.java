package com.qx.shuati.niuke.alibaba2021;

import java.util.*;

/**
 * @author Xuan
 * Date: 2022/4/13
 * Time: 14:59
 */

public class No1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] nums = new int[n][2];
            for (int i = 0; i < 2 * n; i++) {
                nums[i % n][i / n] = sc.nextInt();
            }
            Arrays.sort(nums, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            });
            int[][] dp = new int[n + 1][2];
            int len = 1;
            dp[1] = nums[0];
            for (int i = 1; i < n; i++) {
                if (dp[len][1] < nums[i][1]) {
                    dp[++len] = nums[i];
                } else if (dp[len][1] > nums[i][1]) {
                    int l = 1, r = len, pos = 0;
                    while (l <= r) {
                        int mid = (l + r) >> 1;
                        if (dp[mid][1] < nums[i][1]) {
                            pos = mid;
                            l = mid + 1;
                        } else {
                            r = mid - 1;
                        }
                    }

                    dp[pos + 1] = nums[i];

                }
            }
            System.out.println(len);
        }
    }
}
