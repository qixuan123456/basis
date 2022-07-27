package com.qx.day21.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuan
 * @date 2022/5/18 13:44
 */
public class No823 {

    public static void main(String[] args) {
        No823 no823 = new No823();
        System.out.println(no823.numFactoredBinaryTrees(new int[]{45,42,2,18,23,1170,12,41,40,9,47,24,33,28,10,32,29,17,46,11,759,37,6,26,21,49,31,14,19,8,13,7,27,22,3,36,34,38,39,30,43,15,4,16,35,25,20,44,5,48}));
    }

    public int numFactoredBinaryTrees(int[] arr) {
        long mod = 1000000007L;
        Arrays.sort(arr);
        Map<Integer,Long> map = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            double d = Math.sqrt(a);
            long an = 0L;
            for (int j = 2; j <= d; j++) {
                int c = a%j;
                if(c==0&&map.containsKey(j)&&map.containsKey(a/j)){
                    long x = map.get(j),y = map.get(a/j);
                    long temp = (x*y)%mod;
                    if(j==a/j){
                        ans = (ans+ temp)%mod;
                        an = (an +temp)%mod;
                    }else {
                        ans = (ans+ 2*temp)%mod;
                        an = (an+2*temp)%mod;
                    }
                }
            }
            map.put(a,an+1);
            ans++;
        }
        return (int)(ans%mod);
    }
}
