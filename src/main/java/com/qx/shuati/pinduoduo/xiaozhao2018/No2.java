package com.qx.shuati.pinduoduo.xiaozhao2018;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/7/14 13:48
 */
public class No2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int[] ints1 = new int[s1.length()];
        for (int i = 0; i < s1.length(); i++) {
            ints1[i] = s1.charAt(i)-'0';
        }
        int[] ints2 = new int[s2.length()];
        for (int i = 0; i < s2.length(); i++) {
            ints2[i] = s2.charAt(i)-'0';
        }
        int[] ints = cheng(ints1,ints2);
        boolean flag = false;
        for (int anInt : ints) {
            if(!flag&&anInt==0){
                continue;
            }
            flag = true;
            System.out.print(anInt);
        }
        System.out.println();
        System.out.println(1234*999);
    }

    public static int[] cheng(int[] ints1 ,int[] ints2){
        int[] ints = new int[ints1.length+ints2.length];

        for (int i = 0; i < ints2.length; i++) {
            add(ints,cheng(ints1,ints2[i],ints2.length-i-1));
        }
        return ints;
    }
    public static int[] cheng(int[] ints,int a,int l){
        int[] res = new int[ints.length+l+1];
        int add = 0;
        for (int i = ints.length-1; i >= 0; i--) {
            int c = (add+(a*ints[i]))%10;
            add = (add+(a*ints[i]))/10;
            res[i+1] = c;
        }
        res[0] = add;
        return res;
    }
    public static void add(int[] ints1 ,int[] ints2){
        int add = 0;

        for (int i = ints1.length-1,j = ints2.length-1; i >=0 ; i--,j--) {
            int c;
            if(j<0){
                c = (add + ints1[i]) % 10;
                add = (add+ints1[i])/10;
            }else {
                c = (add + ints1[i] + ints2[j]) % 10;
                add = (add+ints1[i]+ints2[j])/10;
            }
            ints1[i] = c;

        }
    }
}
