package com.qx.zhenti.meituan.no2021_4;

import java.util.*;

/**
 * @author xuan
 * @date 2022/8/13 12:44
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int M = scanner.nextInt();
        int T = scanner.nextInt();
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            lists[a].add(b);
            lists[b].add(a);
        }

        int[] a = new int[n];
        int[] b = new int[n];
        bfs(a, M - 1, lists);
        bfs(b, T - 1, lists);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (b[i] < a[i]) {
                ans = Math.max(ans, a[i]);
            }
        }
        System.out.println(ans);
    }

    public static void bfs(int[] nums, int index, List<Integer>[] lists) {
        int current = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] flag = new boolean[nums.length];
        queue.add(index);
        flag[index] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            current++;
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                for (int j = 0; j < lists[poll].size(); j++) {
                    if (!flag[lists[poll].get(j)]) {
                        queue.add(lists[poll].get(j));
                        flag[lists[poll].get(j)] = true;
                        nums[lists[poll].get(j)] = current;
                    }
                }
            }

        }
    }
}
