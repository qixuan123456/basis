package com.qx.shuati.leetcode;

/**
 * @author Xuan
 * Date: 2021/11/30
 * Time: 15:11
 */
public class No400 {

    public static void main(String[] args) {
        No400 no400 = new No400();
        System.out.println(no400.findNthDigit(1000000000));
    }

    public int findNthDigit(int n) {
        long i = 9L;
        int length = 1;
        long sum = 0L;
        while(n>(sum+i*length)){
            sum += i*length;
            i *= 10;
            length++;
        }

        double start = n-sum;
        int a = (int )Math.ceil(start/length);
        int b = (int)Math.pow(10,length-1)-1;
        String s = String.valueOf(a+b);
        return s.charAt((int)(start-1)%length)-'0';
    }

    
}
