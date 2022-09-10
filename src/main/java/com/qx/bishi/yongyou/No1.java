package com.qx.bishi.yongyou;

/**
 * @author xuan
 * @date 2022/9/9 19:25
 */
public class No1 {

    public static void main(String[] args) {
        System.out.println(calculateTotal(4));
    }
    public static long calculateTotal (int count) {
        // write code here
        int i = 1,j=0,x,month;
        for(month = 1;month<count;month++){
            x = i;
            i = i+j;
            j =x;
        }
        return i;
    }
}
