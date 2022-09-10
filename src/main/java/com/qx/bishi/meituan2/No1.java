package com.qx.bishi.meituan2;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/27 16:03
 */
public class No1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String S = scanner.nextLine();
        String s = scanner.nextLine();
        if(S.length()<s.length()){
            System.out.println(0);
            return;
        }

        int ans = 0;

        for (int i = 0; i <= S.length()-s.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j)=='*'){
                    continue;
                }
                if(S.charAt(i+j)==s.charAt(j)){
                    continue;
                }else {
                    flag = false;
                    break;
                }
            }
            if(flag){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
