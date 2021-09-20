package day21.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class No165 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String version1 = scanner.nextLine();
        String version2 = scanner.nextLine();
        System.out.println(compareVersion(version1,version2));
    }

    public static int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int len1 = s1.length;
        int len2 = s2.length;
        int length = Math.min(s1.length,s2.length);
        for (int i = 0; i < length; i++) {
            if(Integer.parseInt(s1[i])>Integer.parseInt(s2[i])){
                return 1;
            }else if(Integer.parseInt(s1[i])<Integer.parseInt(s2[i])){
                return -1;
            }
        }
        if(len1>len2){
            for (int i = len2; i < len1; i++) {
                if(Integer.parseInt(s1[i])>0){
                    return 1;
                }
            }
        }else {
            for (int i = len1; i < len2; i++) {
                if(Integer.parseInt(s2[i])>0){
                    return -1;
                }
            }
        }

        return 0;
    }
}
