package com.qx.shuati.leetcode;

public class No1732 {
    public static void main(String[] args) {
        int[] gain = {-5,1,5,0,-7};
        System.out.println(largestAltitude(gain));
    }
    public static int largestAltitude(int[] gain) {
        int max=0,a=0;
        for (int value : gain) {
            a+=value;
            if (max < a) {
                max = a;
            }
        }
        return max;
    }
}
