package com.qx.day21.leetcode;

import com.qx.day21.tool.Util;


public class No66 {
    public static void main(String[] args) {
    int[] digits = {9,9,9,9};
    Util.printArray(digits);

    Util.printArray(plusOne(digits));
    }
    public static int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]+1<10){
                digits[i] += 1;
                break;
            }
            else{
                digits[i]=0;
            }
        }
        if(digits[0]==0){
            int[] newDigits = new int[digits.length+1];
            newDigits[0]=1;
            return newDigits;
        }
        return digits;
    }
}
