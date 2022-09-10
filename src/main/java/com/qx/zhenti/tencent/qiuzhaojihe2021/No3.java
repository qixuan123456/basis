package com.qx.zhenti.tencent.qiuzhaojihe2021;

import java.util.Scanner;
public class No3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String w = scanner.nextLine();
        int[] nums = new int[N];
        for (int i = 0; i < w.length(); i++) {
            if(w.charAt(i)=='b'){
                nums[i] = 0;
            }else {
                nums[i] = 1;
            }
        }
        System.out.println(solution(nums));
    }

    // 1 0 1 0 0 1
    public static int solution(int[] nums) {
        int[] pre = new int[nums.length];
        int[] suffix = new int[nums.length];

        int p = 0;
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            pre[i] = p + nums[i];
            p = pre[i];
            suffix[nums.length - i - 1] = s + nums[nums.length - i - 1];
            s = suffix[nums.length - i - 1];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.min(ans,
                    Math.min((nums.length - i) - suffix[i], suffix[i]) +
                            Math.min(i - (pre[i] - nums[i]), (pre[i] - nums[i])));
        }
        return ans;
    }
}
