package com.qx.zhenti.vivo.xiaozhaoA2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author xuan
 * @date 2022/7/7 12:35
 */
public class No3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int output = solution(inputStr);
        System.out.println(output);
    }

    private static int solution(String str) {

        // TODO Write your code here
        int ans = 0;
        int index = str.indexOf('0');
        int temp = 0;
        for (int i = index + 1; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                temp++;
            } else {
                temp--;
            }
        }
        ans = temp;
        temp = 0;
        for (int i = 0; i < index; i++) {
            if (str.charAt(i) == ')') {
                temp--;
            } else {
                temp++;
            }
        }
        return Math.min(ans,temp);
    }
}
