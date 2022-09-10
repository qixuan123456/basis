package com.qx.shuati.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No6 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s,numRows));
    }
    public static String convert(String s, int numRows) {
        if(numRows<2){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            list.add(new StringBuilder());
        }
        int a = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            list.get(a).append(s.charAt(i));
            if(a==0){
                flag = true;
            }else if(a==numRows-1){
                flag = false;
            }
            if(flag){
                a++;
            }else {
                a--;
            }
        }
        StringBuilder s1 = new StringBuilder();
        for (StringBuilder stringBuilder:list){
            s1.append(stringBuilder.toString());
        }
        return s1.toString();
    }
}
