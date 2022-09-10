package com.qx.zhenti.tencent.qiuzhaojihe2021;

import java.util.*;

/**
 * @author xuan
 * @date 2022/7/27 20:24
 */
public class No4 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        char[][] map = new char[N][];
        for (int i = 0; i < N; i++) {
            map[i] = scanner.nextLine().toCharArray();
        }
        boolean[][] flag = new boolean[N][N];
        int ans1 = 0;
        int ans2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!flag[i][j] && map[i][j] == '#') {
                    List<int[]> list = new ArrayList<>();
                    dfs(map, flag, i, j, N, list);
                    ans1++;
                    int min = Integer.MAX_VALUE;
                    for (int[] ints : list) {
                        min = Math.min(bfs(map, new boolean[N][N], ints, N),min);
                    }
                    ans2+= min;
                }
            }
        }


        System.out.print(ans1 + " " + ans2);
    }

    public static int bfs(char[][] map, boolean[][] flag, int[] z, int N) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(z);
        flag[z[0]][z[1]] =true;
        int step = 0;
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] pull = queue.poll();
                int[][] f = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                for (int j = 0; j < 4; j++) {
                    int x = pull[0] + f[j][0];
                    int y = pull[1] + f[j][1];
                    if (x < 0 || x >= N || y < 0 || y >= N || flag[x][y] || map[x][y] == '*') {
                        continue;
                    }
                    if(map[x][y]=='#'){
                        res += step;
                    }
                    queue.add(new int[]{x, y});
                    flag[x][y] = true;
                }
            }

        }
        return res;
    }

    public static void dfs(char[][] map, boolean[][] flag, int x, int y, int N, List<int[]> list) {
        if (x < 0 || x >= N || y < 0 || y >= N || flag[x][y] || map[x][y] == '*') {
            return;
        }
        flag[x][y] = true;
        list.add(new int[]{x, y});
        int[][] f = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < 4; i++) {
            dfs(map, flag, x + f[i][0], y + f[i][1], N, list);
        }
    }
}
