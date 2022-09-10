package com.qx.shuati.tool;

public class Util {
    public static <T> void printArray(T[] a){
        for (T i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
    public static <T> void print2Array(T[][] a){
        for (T[] ts : a) {
            for (T t : ts) {
                System.out.print(t + "\t");
            }
            System.out.println();
        }
    }
    public static void printArray(int[] a){
        for (int i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
    public static void printArray(int[] a,int n){
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println();
    }
    public static <T> void print2Array(int[][] a){
        for (int[] ts : a) {
            for (int t : ts) {
                System.out.print(t + "\t");
            }
            System.out.println();
        }

    }

    public static void printArray(char[] a){
        for (char i : a) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
    public static void print2Array(char[][] a){
        for (char[] ts : a) {
            for (char t : ts) {
                System.out.print(t + "\t");
            }
            System.out.println();
        }
    }

}
