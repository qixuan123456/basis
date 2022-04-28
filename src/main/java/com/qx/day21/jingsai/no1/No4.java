package com.qx.day21.jingsai.no1;

import java.util.*;

/**
 * @author Xuan
 * Date: 2021/12/30
 * Time: 20:28
 */
public class No4 {
    public static void main(String[] args) {

    }

    public int kIncreasing(int[] arr, int k) {
        int n = arr.length;
        int p = n/k;
        int t = n%k;
        int ans = 0;
        for(int i = 0; i < k; i++){
            int total = i<t?p+1:p;
            int[] temp = new int[total];
            int len = 0;
            for(int j = i; j < n; j+=k){
                if(len == 0 || temp[len-1]<=arr[j]){
                    temp[len++]=arr[j];
                }else{
                    int index = Arrays.binarySearch(temp,0,len,arr[j]);
                    int insert = index>=0?index+1:-index-1;
                    temp[insert] = arr[j];
                }
            }

            ans += total-len;
        }

        return ans;
    }
}
