package com.qx.shuati.leetcode;

/**
 * User: xuan
 * Date: 2021/9/30
 * Time: 12:08
 */
public class No223 {
    public static void main(String[] args) {
        System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int sum = (ay2 - ay1) * (ax2 - ax1) + (by2 - by1) * (bx2 - bx1);
        if (bx2 <= ax1 || by1 >= ay2 || bx1 >= ax2 || by2 <= ay1) {
            return sum;
        }
        int cx1, cy1, cx2, cy2;
        cx1 = Math.max(ax1, bx1);
        cy1 = Math.max(ay1, by1);
        cx2 = Math.min(ax2, bx2);
        cy2 = Math.min(ay2, by2);
        return sum - (cy2 - cy1) * (cx2 - cx1);
    }
}
