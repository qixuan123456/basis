package com.qx.shuati.meituan;

import java.util.Scanner;

/**
 * @author Xuan
 * Date: 2021/12/31
 * Time: 13:30
 */
public class No13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        int ans= 0;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            if(chars[i]=='E'){
                sum++;
            }else {
                if(sum>0){
                    sum--;
                }
            }
            ans = Math.max(sum,ans);
        }
        System.out.println(ans);
    }

}
