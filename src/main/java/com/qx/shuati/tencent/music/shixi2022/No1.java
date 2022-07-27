package com.qx.shuati.tencent.music.shixi2022;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/6/17 13:29
 */
public class No1 {
    public static void main(String[] args) {

    }

    public int minCnt (String s) {
        // write code here
        int n = s.length();
        int[] countOne = new int[n];
        int a = 0;
        for (int i = n -1; i >= 0; i--) {
            countOne[i] = a;
            a+=s.charAt(i)-'0';
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)=='1'){
                ans = Math.min(ans,i+countOne[i]);
            }
        }
        return ans;
    }
}
