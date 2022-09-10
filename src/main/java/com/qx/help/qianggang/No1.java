package com.qx.help.qianggang;

import java.util.Map;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/31 17:05
 */
public class No1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += get(i);
        }
        System.out.println(ans);
    }

    public static int get(int num){
        int k = 1;
        int res = 0;
        while(k<=num){
            k = k<<1;
            res++;
        }
        return res;
    }
}
