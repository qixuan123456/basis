package com.qx.shuati.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Xuan
 * Date: 2021/12/31
 * Time: 13:53
 */
public class No14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt(), y = scanner.nextInt();
        int[] c = new int[x+y];
        int[] xy = new int[x+y];

        for (int i = 0; i < x + y; i++) {
            c[i] = xy[i]= scanner.nextInt();
        }
        Arrays.sort(c);
        StringBuilder sb = new StringBuilder();
        if(x<y){
            int count = c[y];
            for (int i = 0; i < x + y; i++) {
                if(xy[i]<count){
                    sb.append('B');
                }else {
                    sb.append('A');
                }
            }
        }else if(x>y){
            int count = c[x];
            for (int i = 0; i < x + y; i++) {
                if(xy[i]<count){
                    sb.append('A');
                }else {
                    sb.append('B');
                }
            }
        }else {
            for (int i = 0; i < x; i++) {
                sb.append('A');
            }
            for (int i = 0; i < y; i++) {
                sb.append('B');
            }
        }

        System.out.println(sb);
    }
}
