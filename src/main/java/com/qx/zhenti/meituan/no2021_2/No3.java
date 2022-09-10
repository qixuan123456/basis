package com.qx.zhenti.meituan.no2021_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/7 14:54
 */
public class No3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[][] s = new String[N][2];
        for (int i = 0; i < N; i++) {
            s[i] = scanner.nextLine().split(" ");
        }
        int ans = 0;
        String start = "";
        for (int i = 0; i < s.length; i++) {
            if(start.equals("")){
                start = s[i][0];
            }else {
                if(start.equals(s[i][1])){
                    start = "";
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
