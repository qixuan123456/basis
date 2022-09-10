package com.qx.shuati.leetcode;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2022/8/10 14:41
 */
public class No454 {

    public static void main(String[] args) {

    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Arrays.sort(nums4);
        int n = nums1.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = -(nums1[i] + nums2[j]);
                if(nums3[0]+nums4[0]>temp){
                    break;
                }
                if(nums3[n-1]+nums4[n-1]<temp){
                    continue;
                }
                int l = 0;
                int r = n - 1;

                while (l < n && r >= 0) {
                    int sum = nums3[l] + nums4[r];
                    if (sum == temp) {
                        int ll = 1;
                        l++;
                        while (l < n && nums3[l] == nums3[l - 1]) {
                            l++;
                            ll++;
                        }
                        int rr = 1;
                        r--;
                        while (l < n && nums4[r] == nums4[r - 1]) {
                            r--;
                            rr++;
                        }
                        ans += (ll * rr);
                    } else if (sum < temp) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}
