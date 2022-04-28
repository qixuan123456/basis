package com.qx.day21.leetcode;


import com.qx.day21.tool.Util;

import java.util.Scanner;

/**
 * User: xuan
 * Date: 2021/10/8
 * Time: 16:00
 */
public class No2028 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        No2028 no2028 = new No2028();
        while(scanner.hasNext()){
            int m = scanner.nextInt();
            int[] rolls = new int[m];
            for (int i = 0; i < m; i++) {
                rolls[i] = scanner.nextInt();
            }
            int mean = scanner.nextInt();
            int n = scanner.nextInt();
            Util.printArray(no2028.missingRolls(rolls,mean,n));
        }
    }
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = (rolls.length+n)*mean;
        for (int roll : rolls) {
            sum -= roll;
        }
        if((double)sum/n>6||sum<n){
            return new int[]{};
        }
        int b = sum/n;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = b;
        }
        sum -=b*n;
        while (sum>0){
            sum--;
            res[sum] = res[sum]+1;
        }
        return res;
    }
}
