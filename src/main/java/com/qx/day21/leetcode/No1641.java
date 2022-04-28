package com.qx.day21.leetcode;

/**
 * @author Xuan
 * Date: 2021/12/21
 * Time: 20:53
 */
public class No1641 {
    public static void main(String[] args) {
        System.out.println(countVowelStrings(1));
    }
    public static int countVowelStrings(int n) {
        int[] res = {1,1,1,1,1};
        while(n-->1){
            int sum=1;
            int sum1 =1;
            for(int i=1;i<5;i++){
                sum += res[i];
                res[i]=sum1+res[i];
                sum1 = sum;
            }
        }
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum+=res[i];
        }
        return sum;
    }
}
