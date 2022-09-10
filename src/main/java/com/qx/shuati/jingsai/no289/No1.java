package com.qx.shuati.jingsai.no289;

/**
 * @author xuan
 * @date 2022/4/18 14:21
 */
public class No1 {
    public static void main(String[] args) {
        System.out.println(digitSum("00000000",3));
    }
    public static String digitSum(String s, int k) {
        if(s.length()<=k){
            return s;
        }
        int lenC = s.length()/k+(s.length()%k==0?0:1);
        char[][] chars = new char[lenC][k];

        for (int i = 0; i < s.length(); i++) {
            chars[i/k][i%k] = s.charAt(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lenC; i++) {
            sb.append(add(chars[i]));
        }
        return digitSum(sb.toString(), k);
    }
    public static int add(char[] chars){
        int res = 0;
        for (char aChar : chars) {
            if (aChar != 0) {
                res += (aChar - '0');
            }
        }
        return res;
    }
}
