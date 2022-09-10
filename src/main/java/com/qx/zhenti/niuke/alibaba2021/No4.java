package com.qx.zhenti.niuke.alibaba2021;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Xuan
 * Date: 2022/4/14
 * Time: 16:33
 */
public class No4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        char[][] chars = new char[m][n];
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                chars[i][j] = s.charAt(j);
            }
        }
        System.out.println(bfs(chars, m, n));
    }

    public static int bfs(char[][] map, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> queue1 = new LinkedList<>();
        int[] start = new int[2];
        int[] end = new int[2];
        int[][] step = new int[m][n];
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else {
                    if (map[i][j] == 'E') {
                        end[0] = i;
                        end[1] = j;
                    }
                }
            }
        }
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            if (poll[0] == end[0]&&poll[1] == end[1]) {
                return ans;
            }
            //上下左右
            for (int i = 0; i < 4; i++) {
                int x = poll[0] + direction[i][0];
                int y = poll[1] + direction[i][1];
                if (x >= 0 && y >= 0 && x < m && y < m && map[x][y] != '#') {
                    queue1.add(new int[]{x, y});
                    map[x][y] = '#';
                    step[x][y] = step[poll[0]][poll[1]];
                }
            }
            //中心对成点
            if (step[poll[0]][poll[1]] < 5) {
                int x = m - poll[0] - 1;
                int y = n - poll[1] - 1;
                if (map[x][y] != '#') {
                    queue1.add(new int[]{x, y});
                    map[x][y] = '#';
                    step[x][y] = step[poll[0]][poll[1]] + 1;
                    System.out.print(step[x][y]+"  ");
                }
            }
            if (queue.isEmpty()) {
                queue.addAll(queue1);
                queue1.clear();
                ans++;
            }
        }
        return -1;
    }
}
