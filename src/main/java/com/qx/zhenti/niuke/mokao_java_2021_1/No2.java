package com.qx.zhenti.niuke.mokao_java_2021_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/19 16:59
 */
public class No2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        int a = solution(s);
        int b = solution(sc.nextLine());
        int c = solution(sc.nextLine());

        if(Math.min(a,Math.min(b,c))+n>=s.length()){
            System.out.println("draw");
            return;
        }

        if (a > b && a > c) {
            System.out.println("xiaoming");
        } else if (b > a && b > c) {
            System.out.println("xiaowang");
        } else if (c > a && c > b) {
            System.out.println("xiaoli");
        } else {
            System.out.println("draw");
        }
    }


    public static int solution(String s) {
        int[] chars = new int[256];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }

        return Arrays.stream(chars).max().getAsInt();
    }
}
