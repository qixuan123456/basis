package com.qx.zhenti.Shopee.sre_2022;

/**
 * @author xuan
 * @date 2022/7/19 16:09
 */
public class No3 {

    public int cost (int[] array) {
        // write code here
        int[] temp = new int[array.length];


        for (int i = 1; i < array.length; i++) {
            if(array[i]>array[i-1]){
                temp[i] = temp[i]+1;
            }
        }

        for (int i = array.length-2; i >= 0; i--) {
            if(array[i]>array[i+1]){
                temp[i] = Math.max(temp[i],temp[i+1]+1);
            }
        }

        int ans = temp.length;
        for (int i = 0; i < temp.length; i++) {
            ans+=temp[i];
        }
        return ans;
    }
}
