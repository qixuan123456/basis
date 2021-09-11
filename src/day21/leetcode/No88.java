package day21.leetcode;

import day21.tool.Util;

import java.util.Arrays;

public class No88 {
    public static void main(String[] args) {
        int[] nums1 ={1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m=3,n=3;
        merge(nums1,m,nums2,n);
        Util.printArray(nums1,m+n);

    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n >= 0)
            System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1,0,m+n);
    }
}
