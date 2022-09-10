package com.qx.shuati.jingsai.no1;

/**
 * @author Xuan
 * Date: 2021/12/30
 * Time: 19:56
 */
public class No2 {
    public static void main(String[] args) {
        System.out.println(addSpaces("icodeinpython",new int[]{1,5,7,9}));
    }
    public static String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < spaces.length; i++) {
            sb.insert(spaces[i]+i, ' ');
        }
        return sb.toString();
    }
}
