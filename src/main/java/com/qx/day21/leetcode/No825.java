package com.qx.day21.leetcode;

import java.util.Arrays;

/**
 * @author Xuan
 * Date: 2021/12/27
 * Time: 16:09
 */
public class No825 {

    public static void main(String[] args) {
        int[] ages = {16,16,17};
        System.out.println(numFriendRequests(ages));
    }
    public static int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int ans = 0;
        int left = 0;
        int right = 0;
        for(int i = 0;i < ages.length;i++){
            if(ages[i]<=14){
                continue;
            }
            while(ages[left]<=0.5*ages[i]+7){
                left++;
            }
            while(right+1<ages.length&&ages[right+1]<=ages[i]){
                right++;
            }
            ans += right-left;
        }
        return ans;
    }
}
