package com.qx.day21.leetcode;

/**
 * @author xuan
 * @date 2022/5/29 18:03
 */
public class No468 {
    public static void main(String[] args) {
        System.out.println(validIPAddress("f:f:f:f:f:f:f:f"));
    }

    public static String validIPAddress(String queryIP) {
        if(queryIP.contains(".")){
            String[] s = queryIP.split("\\.",-1);
            if(s.length!=4){
                return "Neither";
            }
            for (int i = 0; i < s.length; i++) {
                if(s[i].length()>1&&s[i].charAt(0)=='0'){
                    return "Neither";
                }
                int a = 0;
                try{
                    a = Integer.parseInt(s[i]);
                }catch (Exception e){
                    return "Neither";
                }
                if(a<0||a>255){
                    return "Neither";
                }
            }
            return "IPv4";
        }else {
            String[] s = queryIP.split(":",-1);
            if(s.length!=8){
                return "Neither";
            }
            for (int i = 0; i < s.length; i++) {
                if(s[i].length()<1||s[i].length()>4){
                    return "Neither";
                }
                int a = 0;
                try{
                    a = Integer.parseInt(s[i],16);
                }catch (Exception e){
                    return "Neither";
                }
            }
            return "IPv6";
        }
    }
}
