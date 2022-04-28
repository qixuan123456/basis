package com.qx.day21.leetcode;

/**
 * @author Xuan
 * Date: 2021/11/15
 * Time: 20:43
 */
public class No319 {

    public static void main(String[] args) {
        No319 no319 = new No319();
        System.out.println(no319.bulbSwitch(12));
    }
    public int bulbSwitch(int n) {
        if(n<2){
            return n;
        }
        if(n==3){
            return 1;
        }
        int sum = n;
        int[] as = new int[n+1];
        for(int i = 2;i<=n;i++){
            for(int j = i;j<=n;j+=i){
                if(as[j]==1){
                    as[j]=0;
                    sum++;
                }else{
                    as[j]=1;
                    sum--;
                }
            }
        }
        return sum;
    }
}
