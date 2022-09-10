package com.qx.zhenti.niuke.alibaba2021;

import java.util.*;

/**
 * @author Xuan
 * @Date: 2022/4/14
 * @Time: 18:57
 */
public class No6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> links = new ArrayList<>();
        int[] cityLevel = new int[n];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            cityLevel[i] = sc.nextInt();
            links.add(i, new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            links.get(a-1).add(b-1);
            links.get(b-1).add(a-1);
        }

        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] isUsed = new boolean[n];
            int current = 0;
            boolean flag = false;
            queue.offer(i);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int poll = queue.poll();
                    if (poll != i && cityLevel[poll] == cityLevel[i]) {
                        ans = Math.min(ans, current);
                        flag = true;
                        break;
                    }
                    for (int link : links.get(poll)) {
                        if (!isUsed[link]) {
                            queue.offer(link);
                            isUsed[link] = true;
                        }
                    }
                }
                if(flag){
                    break;
                }
                current++;
            }

        }
        if (ans != Integer.MAX_VALUE) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }
}
