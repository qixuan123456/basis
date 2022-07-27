package com.qx;

/**
 * @author xuan
 * @date 2022/7/8 14:20
 */
public class No2 {
    public int minSwaps(int[] chess) {
        int length = 0;
        for (int i = 0; i < chess.length; i++) {
            if(chess[i]==1){
                length++;
            }
        }
        int left = 0,right = 0;
        int max = 0,current = 0;
        while(right<chess.length){
            if(right-left+1<=length){
                if(chess[right]==1){
                    current++;
                }
                right++;
            }else {
                if(chess[right]==1){
                    current++;
                }
                if(chess[left]==1){
                    current--;
                }
                right++;
                left++;
            }
            max = Math.max(max,current);
        }
        return left-max;
    }
}
