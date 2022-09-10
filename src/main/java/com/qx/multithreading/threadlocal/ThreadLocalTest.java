package com.qx.multithreading.threadlocal;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/3 19:49
 */
public class ThreadLocalTest {

//    public static void main(String[] args) {
//
//
//        ThreadLocal<String> threadLocal = new ThreadLocal<>();
//        threadLocal.get();
//        double a = 10.155;
//        System.out.printf("%.1f %.2f%n",a,a);
//    }

//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextInt()){
//
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            double ans = getAns(n,m);
//                    System.out.printf("%.2f",ans);
//        }
//    }
//
//
//    public static double getAns(int n,int m){
//        double ans = 0;
//        double a = (double) n;
//        while(m-->0){
//            ans+=a;
//            a = Math.sqrt(a);
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            while (n<=m){
                int a = n/100;
                int b = n/10%10;
                int c = n%10;
                if(Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3)==n){
                    System.out.print(n+" ");
                }
                n++;
            }
            System.out.println();
        }

    }
}
