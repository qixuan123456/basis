package com.qx.day23;

public class fangcheng {
    public static void main(String[] args) {
        long k = 2;
        System.out.println(panduan(k));
    }

    public static boolean panduan(long k){
        double k1=Math.pow(k,1.0/3);
        double k2=Math.pow(k,1.0/4);
        double k3=Math.pow(k,1.0/5);
        for (long i= 1; i < k1; i++) {
            for (long j= 1; j < k2; j++) {
                for (long l = 1; l < k3; l++) {
                    if(i*i*i+j*j*j*j+l*l*l*l*l==k){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
