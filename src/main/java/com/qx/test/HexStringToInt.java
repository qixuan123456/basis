package com.qx.test;


public class HexStringToInt {
    public static void main(String[] args) {
        String s =  "0x3067ab956b9b874b";//3488674071531652978
        String ss = "0x3067ab";
        String sss =  "3067ab956b9b874b";
        System.out.println(HexStringToInt(s));
        System.out.println(HexStringToInt(ss));
        System.out.println(Integer.parseInt("12",16));
    }
    public static long HexStringToInt(String s){
        long b=0;
        if(s==null||s.length()<3) {
            return b;
        }
        long a = 0L;
        for (int i =2;i<s.length();i++){

            char c = s.charAt(i);
            if(c>='a'&&c<='z') {
                b = c - 'a' + 10;
            }
            else if(c>='A'&&c<='Z'){
                b = c - 'A' + 10;
            }
            else {
                b = c - '0';
            }
            a = a * 16 + b;
        }
        return a;
    }
}
