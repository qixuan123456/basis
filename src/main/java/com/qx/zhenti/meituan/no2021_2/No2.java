package com.qx.zhenti.meituan.no2021_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/7 14:37
 */
public class No2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        solution(scanner.nextInt());
    }

    public static void solution(int num) {
        int ans = 0;
        List<int[]> list = new ArrayList<>();

        for (int i = 1; i <= num; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            int a = Integer.parseInt(String.valueOf(sb.reverse()));
            if (i * 4 == a && a <= num) {
                list.add(new int[]{i, a});
                ans++;
            }
        }
        System.out.println(ans);
        list.forEach((a) -> System.out.println(a[0] + " " + a[1]));
    }
}
