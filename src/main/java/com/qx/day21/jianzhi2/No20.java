package com.qx.day21.jianzhi2;

/**
 * @author xuan
 * @date 2022/7/5 19:12
 */
public class No20 {

    public static void main(String[] args) {

        System.out.println(isNumber("1 "));
    }
    public static boolean isNumber(String s) {
        char c = s.charAt(s.length()-1);
        s = s.trim();

        try {
            if(!Character.isDigit(c)&&c!='.'){
                return false;
            }
            Double.valueOf(s);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
