package com.qx.shuati.pinduoduo.xiaozhao2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/7/14 13:28
 */
public class No3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums1 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] nums2 = new int[m];
        for (int i = 0; i < m; i++) {
            nums2[i] = sc.nextInt();
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int r = n-1,l = m-1;
        int ans = 0;
        while (l>=0&&r>=0){
            while(r>=0){
                if(nums1[r]<=nums2[l]){
                    ans++;
                    l--;
                    r--;
                    break;
                }else {
                    r--;
                }
            }
        }
        System.out.println(ans);
    }
}
