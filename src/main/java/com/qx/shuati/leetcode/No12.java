package com.qx.shuati.leetcode;

public class No12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
    public static String intToRoman(int num) {
        int n = 1000;
        char c = 'M';
        char cc = ' ';
        char ccc = ' ';
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            switch (n){
                case 1: c = 'I';cc = 'V';ccc = 'X';break;
                case 10: c = 'X';cc = 'L';ccc = 'C';break;
                case 100: c = 'C';cc = 'D';ccc = 'M';break;
            }
            int a = num/n;
            num = num%n;
            n = n/10;
            if(a<4){
                for (int j = 0; j < a; j++) {
                    res.append(c);
                }
            }else if(a==4){
                res.append(c);
                res.append(cc);
            }else if(a<9){
                res.append(cc);
                for (int j = 0; j < a - 5; j++) {
                    res.append(c);
                }
            }else  {
                res.append(c);
                res.append(ccc);
            }
        }
        return res.toString();
    }
}
