package com.qx.shuati.leetcode;

/**
 * @author Xuan
 * Date: 2021/12/21
 * Time: 10:56
 */
public class No1154 {

    public static void main(String[] args) {
        System.out.println(new No1154().dayOfYear("2100-03-01"));
    }

    public int dayOfYear(String date) {
        int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] ss = date.split("-");
        int year = Integer.parseInt(ss[0]);
        int month = Integer.parseInt(ss[1]);
        int day = Integer.parseInt(ss[2]);
        boolean flag = false;
        if(year%4==0){
            if(year%100==0){
                if(year%400==0){
                    flag=true;
                }
            }else {
                flag=true;
            }
        }
        if(flag){
            months[1]=29;
        }
        int days = 0;
        for (int i = 0; i < month-1; i++) {
            days+=months[i];
        }
        return days+day;
    }
}
