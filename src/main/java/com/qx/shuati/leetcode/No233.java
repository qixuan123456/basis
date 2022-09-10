package com.qx.shuati.leetcode;
/**
 * @author xuan
 * @date 2022/8/16 19:29
 */
public class No233 {


    public static void main(String[] args) {
        System.out.println(countDigitOne(13));
    }
    public static int countDigitOne(int n) {

        long num = 1;
        long ans = 0;
        while (num<n){
            long a = 0;
            a = n/(num*10);
            ans+=a*num;
            long b = n%(num*10);
            if(b>=2*num){
                ans+=num;
            }else if(b>=num){
                ans+=(b-num+1);
            }

            num = num*10;
        }
        return (int)ans;
    }
}
