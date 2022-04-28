package com.qx.day21.leetcode;

/**
 * User: xuan
 * Date: 2021/9/27
 * Time: 16:47
 */
public class No845 {
    public static void main(String[] args) {
        int[] arr = { 2,3,3,0,2};
        System.out.println(longestMountain(arr));
    }

    public static int longestMountain(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }
        int res = 0;
        int left = 0, right = 0;
        boolean flag = false;
        boolean a = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                if (!flag) {
                    left = i - 1;
                    right = i;
                    a = false;
                    flag = true;
                    continue;
                }
                right++;
            } else if (arr[i] < arr[i - 1]) {
                if (flag) {
                    flag = false;
                    a = true;
                }
                right++;
                if(a){
                    res = Math.max(res, right - left + 1);
                }
            } else {
                left = i;
                right = i;
                a = false;
                flag = false;
            }

        }
        return res;
    }
}
