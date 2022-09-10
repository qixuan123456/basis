package com.qx.shuati.jingsai;

import java.util.*;

/**
 * @author xuan
 * @date 2022/4/24 18:16
 */
public class No290 {


    public static void main(String[] args) {

    }
    public List<Integer> intersection(int[][] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                map.put(nums[i][j],map.getOrDefault(nums[i][j],0)+1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet() ) {
            if(entry.getValue()== nums.length){
                ans.add(entry.getKey());
            }
        }
        ans.sort(Comparator.comparingInt(a -> a));
        return ans;
    }



    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int[] starts = Arrays.stream(flowers).mapToInt(f -> f[0]).sorted().toArray();
        int[] ends = Arrays.stream(flowers).mapToInt(f -> f[1]).sorted().toArray();
        return Arrays.stream(persons).map(p -> lowerBound(starts, p + 1) - lowerBound(ends, p)).toArray();
    }

    int lowerBound(int[] arr, int x) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= x) right = mid;
            else left = mid + 1;
        }
        return left;
    }


































    public int[] countRectangles(int[][] rectangles, int[][] points) {
       return null;
    }

    public int countLatticePoints(int[][] circles) {
        Set<Point> set = new HashSet<>();
        for (int[] circle : circles) {
            single(circle, set);
        }
        return set.size();
    }

    public void single(int[] circle, Set<Point> set) {

        for (int i = circle[0] - circle[2]; i <= circle[0] + circle[2]; i++) {
            for (int j = circle[1] - circle[2]; j <= circle[1] + circle[2]; j++) {
                if (Math.pow(i - circle[0], 2) + Math.pow(j - circle[1], 2) <= Math.pow(circle[2], 2)) {
                    set.add(new Point(i, j));
                }
            }
        }
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
