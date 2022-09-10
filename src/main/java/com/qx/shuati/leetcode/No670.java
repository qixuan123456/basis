package com.qx.shuati.leetcode;

/**
 * @author xuan
 * @date 2022/4/22 12:53
 */
public class No670 {

    public static void main(String[] args) {
        System.out.println(new No670().maximumSwap(21));
    }
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char max = chars[i];
            int index = -1;
            for (int j = i+1; j < chars.length; j++) {
                if(chars[j]>=max){
                    max = chars[j];
                    index = j;
                }
            }
            if(max!=chars[i]){
                chars[index]= chars[i];
                chars[i] = max;
                return Integer.parseInt(new String(chars));
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
