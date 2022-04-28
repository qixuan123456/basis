package com.qx.shuati.meituan;

import java.util.Scanner;

/**
 * @author Xuan
 * Date: 2021/12/20
 * Time: 18:31
 */
public class No1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            int len = Integer.parseInt(scanner.nextLine());
            while ((len--)>0){
                String s = scanner.nextLine();
                if(check(s)){
                    System.out.println("Accept");
                }else {
                    System.out.println("Wrong");
                }
            }
        }
    }
    public static boolean check(String s){

        if(s.length() < 2){
            return false;
        }
        char first = s.charAt(0);
        if(!(('a'<=first&&first<='z')||('A'<=first&&first<='Z'))){
            return false;
        }
        int character = 1;
        int number = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if('0'<=c&&c<='9'){
                number++;
            } else if(('a'<=c&&c<='z')||('A'<=c&&c<='Z')){
                character++;
            }else {
                return false;
            }
        }
        return number != 0;
    }
}
