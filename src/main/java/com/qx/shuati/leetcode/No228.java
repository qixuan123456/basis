package com.qx.shuati.leetcode;

public class No228 {


    public static void main(String[] args) {
        int[] a = {1, 3, 4,6};
        int[] b = {0,0};
        int l=a.length;
        b[0]=a[0];
        b[1]=a[0];
        for (int i = 0; i < l; i++) {
            if(i+1<l){
                if(a[i+1]==a[i]+1){
                    b[1] += 1;
                }
                else {
                    System.out.println(No228.toString(b));
                    b[0]=a[i+1] ;
                    b[1]=a[i+1];
                }
            }
        }
        System.out.println(No228.toString(b));

    }
    public static String toString(int[] b){
        String s="\"";
        for (int i = 0; i < b.length; i++) {
            s=s+(char)(b[i]+48);
        }
        return s+"\"";
    }

}
