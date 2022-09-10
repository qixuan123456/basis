package com.qx.help.xiaosi;

import java.util.PriorityQueue;

/**
 * @author xuan
 * @date 2022/9/2 20:32
 */
public class No5 {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{20, 5, 10, 20, 5, 5}));
    }

    public static String solution(int w, int[] timeArr) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        StringBuilder sb = new StringBuilder();
        int n = timeArr.length;
        for (int i = 0; i < n; i++) {
            if (i < w) {
                queue.add(new int[]{i, timeArr[i]});
                sb.append(i + 1);
            } else {
                int[] poll = queue.poll();
                assert poll != null;
                poll[1] += timeArr[i];
                queue.add(poll);
                sb.append(poll[0] + 1);
            }
        }
        return sb.toString();
    }
}
