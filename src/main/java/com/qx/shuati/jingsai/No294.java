package com.qx.shuati.jingsai;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2022/5/23 14:33
 */
public class No294 {

    public int percentageLetter(String s, char letter) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if(letter==s.charAt(i)){
                ans++;
            }
        }
        return ans*100/s.length();
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] nums = new int[capacity.length];
        int ans = 0;
        for (int i = 0; i < capacity.length; i++) {
            nums[i] = capacity[i]-rocks[i];
        }
        Arrays.sort(nums);

        for (int i = 0; i < capacity.length; i++) {
            if(additionalRocks>=nums[i]){
                ans++;
                additionalRocks -= nums[i];
            }
        }
        return ans;
    }

    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices,(a,b)->a[0]-b[0]);
        if(stockPrices.length<2){
            return 0;
        }
        int ans = 1;
        for (int i = 1; i < stockPrices.length-1; i++) {
            if(!check(stockPrices[i-1],stockPrices[i],stockPrices[i+1] )){
                ans++;
            }
        }
        return ans;
    }
    public boolean check(int[] a,int[] b,int[] c){
        return ((long) b[1]-(long)a[1])*((long)c[0]-(long)b[0])==((long) c[1]-(long)b[1])*((long)b[0]-(long)a[0]);
    }

    public static void main(String[] args) {
        int[] stockPrices ={1,3,1,2};
        System.out.println(new No294().totalStrength(stockPrices));
    }

    public int totalStrength(int[] strength) {
        int mod = 1000000007;
        int len = strength.length;
        long[] pre1 = new long[len];
        long[] pre2= new long[len];
        long ans = 0L;
        int[] min = new int[len];
        int m = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            pre1[i] = (long) (len - i) *strength[i]%mod;
        }

        long a = 0L;
        for (int i = len-1; i >= 0; i--) {
            if(m>strength[i]){
                m = strength[i];
            }
            min[i] = m;
            a=(a+pre1[i])%mod;
            pre2[i] = a;
        }

        for (int i = 0; i <len; i++) {
            ans = (ans+ (min[i]*pre2[i])%mod)%mod;
        }
        return (int)ans;
    }
}
