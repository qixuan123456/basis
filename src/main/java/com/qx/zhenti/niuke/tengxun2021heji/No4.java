package com.qx.zhenti.niuke.tengxun2021heji;

import java.util.*;

/**
 * @author xuan
 * @date 2022/4/15 12:47
 */
public class No4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        char[][] map = new char[n][n];
        char[][] map1 = new char[n][n];
        int[][] H = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int ans1 = 0;
        int ans2 = 0;
        for (int i = 0; i < n; i++) {
            map[i] = sc.nextLine().trim().toCharArray();
            map1[i] = map[i].clone();
        }

        //对每个节点进行深度优先递归统计区域个数，并且统计区域内包含的节点
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //节点为房子需要递归。可能一个区域内没有'#'，那么不需要递归
                if (map1[i][j] == '#') {
                    ans1++; //区域个数也就是商店数量
                    List<int[]> list = new ArrayList<>();//统计本区域内的所有节点
                    dfs(map1, i, j, list);//深度优先递归将这个区域内的节点全部遍历
                    int min = Integer.MAX_VALUE;
                    //将商店设置在coordinate,统计此区域内最小距离和
                    for (int[] coordinate : list) {
                        int min1 = 0;
                        int step = 0; //商店到节点的距离
                        //广度优先
                        boolean[][] flag = new boolean[n][n];
                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(coordinate);
                        flag[coordinate[0]][coordinate[1]] = true;
                        while (!queue.isEmpty()) {
                            int size = queue.size();

                            for (int k = 0; k < size; k++) {
                                int[] poll = queue.poll();
                                int x = poll[0], y = poll[1];
                                //如果此节点是房子，那么需要统计距离
                                if (map[x][y] == '#') {
                                    min1 += step;
                                }
                                for (int l = 0; l < 4; l++) {
                                    int xx = x + H[l][0];
                                    int yy = y + H[l][1];
                                    //超过边界或者不是此区域或者遍历过 则不加入队列
                                    if (xx < 0 || yy < 0 || xx >= n || yy >= n || map[xx][yy] == '*' || flag[xx][yy]) {
                                        continue;
                                    }
                                    queue.offer(new int[]{xx, yy});
                                    //标记已遍历
                                    flag[xx][yy] = true;
                                }
                            }
                            step++;
                        }
                        //求出此区域内的最小距离和
                        min = Math.min(min1, min);
                    }
                    //总的距离和
                    ans2 += min;
                }
            }
        }
        System.out.println(ans1 + " " + ans2);
    }

    /**
     *
     * @param map 备份的地图
     * @param x 纵坐标
     * @param y 横坐标
     * @param list 统计此区域内的节点
     */
    public static void dfs(char[][] map, int x, int y, List<int[]> list) {
        int n = map.length;
        if (x < 0 || y < 0 || x >= n || y >= n || map[x][y] == '*') {
            return;
        }
        list.add(new int[]{x, y});
        //标记已遍历
        map[x][y] = '*';
        //遍历上下左右
        dfs(map, x - 1, y, list);
        dfs(map, x + 1, y, list);
        dfs(map, x, y - 1, list);
        dfs(map, x, y + 1, list);
    }
}
