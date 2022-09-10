package com.qx.bishi.jingdong;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/27 19:30
 */
public class No1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(i<m){
                if(c<='z'&&c>='a'){
                    sb.append((char) (c-32));
                }else {
                    sb.append(c);
                }
            }else {
                if(c<='Z'&&c>='A'){
                    sb.append((char) (c+32));
                }else {
                    sb.append(c);
                }
            }
        }
        System.out.println(sb);
    }
}
