package com.qx.zhenti.niuke.mokao2021_1;

/**
 * @author xuan
 * @date 2022/7/15 18:29
 */
public class No1 {
    public static void main(String[] args) {

    }

    public long NNAplusB (int a, int b) {
        // write code here
        long aa = a;
        long bb = b;
        for (int i = 1; i < b; i++) {
            aa += a*Math.pow(10,i);
        }
        for (int i = 1; i < a; i++) {
            bb += b*Math.pow(10,i);
        }
        return aa+bb;
    }
}
