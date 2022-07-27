package com.qx.day21.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xuan
 * @date 2022/6/7 12:20
 */
public class No875 {

    public static void main(String[] args) {
        
        System.out.println(minEatingSpeed(new int[]{3,6,7,11},8));
    }

    public static int  minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 0,right = piles[piles.length-1];
        while (left<right){
            int mid = (left+right)>>1;
            if(check(piles,mid,h)>0){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    public static int check(int[] piles,int mid,int h){
        int temp = 0;
        for (int i = 0; i < piles.length; i++) {
            temp+=((piles[i]-1)/mid+1);
            if(temp>h){
                return 1;
            }
        }
        return -1;
    }
}
