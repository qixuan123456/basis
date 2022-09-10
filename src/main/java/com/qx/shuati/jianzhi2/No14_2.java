package com.qx.shuati.jianzhi2;

/**
 * @author xuan
 * @date 2022/7/1 14:38
 */
public class No14_2 {

    public int cuttingRope(int n) {
        long ans = 1;
        int mod = 1000000007;
        if(n<4){
            return n-1;
        }
        while (n>4){
            ans = (ans*3)%mod;
            n-=3;
        }
        return (int)((ans*n)%mod);
    }
}
