package com.qx.bishi.kuangshi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class No1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Character> set = new HashSet<>();
        set.add('A');
        set.add('H');
        set.add('I');
        set.add('M');
        set.add('N');
        set.add('O');
        set.add('T');
        set.add('U');
        set.add('V');
        set.add('W');
        set.add('X');
        set.add('Y');
        set.add('Z');
        while (scanner.hasNextLine()){
            boolean flag = true;
            String s = scanner.nextLine();
            for (int i = 0; i <= s.length()/2; i++) {
                if(set.contains(s.charAt(i))&&s.charAt(i)==s.charAt(s.length()-1-i)){
                    continue;
                }else {
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
}
