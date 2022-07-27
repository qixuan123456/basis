package com.qx.day21.leetcode;

/**
 * @author xuan
 * @date 2022/5/31 16:47
 */
public class No1927 {
    public static void main(String[] args) {

    }

    public boolean sumGame(String num) {
        int[] sum = new int[2];
        int[] count = new int[2];
        char[] chars = num.toCharArray();
        int length = num.length() / 2;
        for (int i = 0; i < length; i++) {
            if (chars[i] == '?') {
                count[0]++;
            } else {
                sum[0] += (chars[i] - '0');
            }
            if (chars[i + length] == '?') {
                count[1]++;
            } else {
                sum[1] += (chars[i + length] - '0');
            }
        }
        int a = 0, b = 0;
        if (count[0] == count[1]) {
            return sum[0] != sum[1];
        } else if (count[0] > count[1]) {
            if (sum[0] > sum[1]) {
                return true;
            }
            a = count[0] - count[1];
            b = sum[1] - sum[0];
        } else {
            if (sum[1] > sum[0]) {
                return true;
            }
            a = count[1] - count[0];
            b = sum[0] - sum[1];
        }
        if((a&1)==1){
            return true;
        }
        return b!=(a/2)*9;

    }
}
