package com.qx.zhenti.meituan.no2021_3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author xuan
 * @date 2022/8/12 18:37
 */
public class No2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            value[i] = a + 2 * b;
        }
        solution(value,m);
    }


    public static void solution(int[] value, int m) {
        int len = value.length;
        int ans = 0;
        int[] ints = IntStream.range(0, len).boxed().sorted((a, b) -> value[b] - value[a]).mapToInt(Integer::intValue).toArray();

        Arrays.sort(ints,0,Math.min(m,len));

        for (int i = 0; i < Math.min(len, m); i++) {
            if(i!=0){
                System.out.print(" ");
            }
            System.out.print(ints[i]+1);
        }
    }
}
