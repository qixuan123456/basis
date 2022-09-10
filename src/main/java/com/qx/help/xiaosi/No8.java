package com.qx.help.xiaosi;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/9/9 11:34
 */
public class No8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int ans = 0;
        if (s.length() < 2) {
            System.out.println(0);
        } else {
            int temp = 1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    temp++;
                } else {
                    int a = temp - 1;
                    ans += ((a / 3) + (a % 3 == 0 ? 0 : 1));
                    temp = 1;
                }
            }
            if(temp>1){
                int a = temp - 1;
                ans += ((a / 3) + (a % 3 == 0 ? 0 : 1));
            }
            System.out.println(ans);
        }
    }
}
