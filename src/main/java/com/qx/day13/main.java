package com.qx.day13;

public class main {
    public static void main(String[] args) {
        int i = 0;
        int sum = 0;
        while (sum<1866920){
            sum += 4096;
            i++;
        }
        i--;
        System.out.println(i);
        System.out.println(4096*i);
        System.out.println(1866920-4096*i);
    }
}
