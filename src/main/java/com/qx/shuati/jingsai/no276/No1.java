package com.qx.shuati.jingsai.no276;

import java.util.Arrays;

/**
 * @author Xuan
 * Date: 2022/1/18
 * Time: 19:24
 */
public class No1 {
    public static void main(String[] args) {
        int k = 3;
        String s = "abcdefghij";
        char fill = 'x';
        System.out.println(Arrays.toString(new No1().divideString(s, k, fill)));
    }

    public String[] divideString(String s, int k, char fill) {
        int l = (s.length() + k - 1) / k;
        String[] ss = new String[l];
        char[] chars = s.toCharArray();

        for (int i = 0; i < l-1; i++) {
            ss[i] = new String(chars, k*i, k);
        }
        char[] c = new char[k];
        Arrays.fill(c,fill);
        for (int i = (l-1)*k; i < s.length(); i++) {
            c[i-(l-1)*k] = chars[i];
        }
        ss[l-1] = new String(c);
        return ss;
    }
}
