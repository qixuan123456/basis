package com.qx.bishi.meituan1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author xuan
 * @date 2022/8/13 16:36
 */
public class No2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        Set<String> set = new HashSet<>();
        boolean[][] flag = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                set.add(i +" "+j);
            }
        }
        int x = 0;
        int y = 0;
        set.remove(0+" "+0);
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case 'W': x--;break;
                case 'A': y--;break;
                case 'S': x++;break;
                case 'D': y++;break;
            }
            set.remove(x+" "+y);
            if(set.size()==0){
                System.out.println("True");
                System.out.println(i+1);
                return;
            }
        }

        System.out.println("False");
        System.out.println(set.size());

    }
}
