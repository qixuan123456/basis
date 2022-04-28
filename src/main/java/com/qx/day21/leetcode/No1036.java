package com.qx.day21.leetcode;

import java.util.*;

/**
 * @author Xuan
 * Date: 2022/1/11
 * Time: 10:42
 */
public class No1036 {
    public static void main(String[] args) {
        int[][] blocked = {{100059,100063},{100060,100064},{100061,100065},{100062,100066},{100063,100067},{100064,100068},{100065,100069},{100066,100070},{100067,100071},{100068,100072},
                {100069,100073}};
        int[] source = {0,0};
        int[] target = {99,99};
        System.out.println(isEscapePossible(blocked, source, target));
    }
    public static int max;
    public static boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        max = blocked.length*(blocked.length-1)/2;
        if(blocked.length<2){
            return true;
        }
        return tran(blocked,source,target)&&tran(blocked,target,source);
    }
    public static boolean tran(int[][] blocked,int[] source,int[] target){
        int[] xx = {-1,0,1,0};
        int[] yy = {0,1,0,-1};
        Set<Point> set = new HashSet<>();
        for (int i = 0; i < blocked.length; i++) {
            set.add(new Point(blocked[i]));
        }
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(source));
        while (!queue.isEmpty()){
            int[] point = queue.poll().point;
            for (int i = 0; i < 4; i++) {
                int x = point[0]+xx[i];
                int y = point[1]+yy[i];
                if(!(x<0||x>=1000000||y<0||y>=1000000)){
                    Point cur = new Point(new int[]{x,y});
                    if(cur.equals(new Point(target))){
                        return true;
                    }
                    if(!set.contains(cur)){
                        queue.add(cur);
                        set.add(cur);
                    }

                }
                if(set.size()>max+blocked.length){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(int[] source,int[] target,Set<Point> set){
        if(source[0]==target[0]&&source[1]==target[1]){
            return true;
        }
        if(set.size()>max){
            return true;
        }
        int[] xx = {-1,0,1,0};
        int[] yy = {0,1,0,-1};
        for (int i = 0; i < 4; i++) {
            int x = source[0]+xx[i];
            int y = source[1]+yy[i];
            if(!(x<0||x>=100||y<0||y>=100)){
                if(!set.contains(new Point(new int[]{x,y}))){
                    if(dfs(new int[]{x,y},target,set)){
                        return true;
                    }
                    set.add(new Point(source));
                }

            }
        }
        return false;
    }

    public static class Point{
        int[] point;

        public Point(int[] point) {
            this.point = point;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point1 = (Point) o;
            return Arrays.equals(point, point1.point);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(point);
        }
    }
}
