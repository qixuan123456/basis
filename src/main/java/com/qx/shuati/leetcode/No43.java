package com.qx.shuati.leetcode;

import java.util.Arrays;

/**
 * @author Xuan
 * Date: 2021/12/27
 * Time: 20:57
 */
public class No43 {

    public static void main(String[] args) {
        System.out.println(multiply("999","999"));

    }

    public static String multiply(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num1.toCharArray();
        char[][] ans = new char[num2.length()][num1.length()+num2.length()];

        for (char[] chars : ans) {
            Arrays.fill(chars,'0');
        }
        int len1 = num1.length();
        int len2 = num2.length();
        for (int i = c2.length-1; i >= 0; i--) {
            int a = 0;
            int j = c1.length-1;
            while(j>=0&&(c2[i]!='0'||c1[j]!='0'||a!=0)){
                int aa = (c2[i]-'0')*(c1[j]-'0')+a;
                a = aa/10;
                ans[len2-1-i][j+i+1] = (char) (aa%10+'0');
                j--;
            }
        }
        char[] s = new char[ans[0].length];
        for (int i = 0; i < ans.length; i++) {
            s = add(s,ans[i]);
        }
        return new String(s);
    }

    public static char[] add(char[] num1, char[] num2){
        char[] res = new char[num1.length];
        int a = 0;
        int i = num1.length-1;
        while (i>=0&&(num1[i]!='0'||num2[i]!='0'||a!=0)) {
            int aa = (num1[i]-'0')*(num2[i]-'0')+a;
            a= aa/10;
            res[i] = (char) (aa%10+'0');
            i--;
        }
        return res;
    }
}
