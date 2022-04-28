package com.qx.day21.jingsai.no289;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2022/4/18 14:43
 */
public class No2 {
    public static void main(String[] args) {
        System.out.println(minimumRounds(new int[]{2,2,3,3,2,4,4,4,4,4}));
    }

    public static int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int ans = 0;
        int count = 1;
        for (int i = 1; i < tasks.length; i++) {
            if (tasks[i] != tasks[i - 1]) {
                if (count == 1) {
                    return -1;
                } else {
                    ans+=(count/3+(count%3==0?0:1));
                    count = 1;
                }
            } else {
                count++;
            }
        }
        if (count == 1) {
            return -1;
        }else {
            ans+=(count/3+(count%3==0?0:1));
        }
        return ans;
    }
}
