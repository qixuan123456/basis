package com.qx.bishi.kedaxunfei;

import java.util.ArrayList;


/**
 * @author xuan
 * @date 2022/8/20 18:51
 */
public class No1 {

    public static void main(String[] args) {
        int[][] a = {{0,1,1,1},{0,0,0,1},{1,0,8,1},{1,0,1,1}};
        ArrayList<Point> b = new No1().winMazeGift(a);
        System.out.println();
    }

    public ArrayList<Point> winMazeGift(int[][] maze) {
        // write code here
        Point point = new Point(0,0);
        boolean flag = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (maze[i][j] == 8) {
                    point.x = i;
                    point.y = j;
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        ArrayList<ArrayList<Point>> lists = new ArrayList<>();
        ArrayList<Point> ans = new ArrayList<>();

        dfs(lists,new ArrayList<>(),maze,new boolean[4][4],point);

        int a = Integer.MAX_VALUE;
        for (int i = 0; i < lists.size(); i++) {
            if(lists.get(i).size()<a){
                ans = lists.get(i);
                a = lists.get(i).size();
            }
        }
        ArrayList<Point> b = new ArrayList<>();
        for (int i = ans.size()-1; i >=0; i--) {
            b.add(ans.get(i));
        }
        return b;
    }

    public void dfs(ArrayList<ArrayList<Point>> lists,ArrayList<Point> list,int[][] maze,boolean[][] flag,Point current){
        int[][] f= new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        if(current.x>=4||current.x<0||current.y>=4||current.y<0){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(flag[current.x][current.y]||maze[current.x][current.y]==1){
            return;
        }

        flag[current.x][current.y]=true;
        list.add(current);
        for (int i = 0; i < 4; i++) {
            dfs(lists,list,maze,flag,new Point(current.x+f[i][0],current.y+f[i][1]));
        }
        list.remove(list.size()-1);
        flag[current.x][current.y]=false;

    }

    static public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
