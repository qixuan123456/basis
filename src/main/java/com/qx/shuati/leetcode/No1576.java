package com.qx.shuati.leetcode;

/**
 * @author Xuan
 * Date: 2022/1/5
 * Time: 12:01
 */
public class No1576 {

    public static void main(String[] args) {
        System.out.println(modifyString("a??bz"));
    }

    public static String modifyString(String s) {
        int length = s.length();
        if(length==1){
            if("?".equals(s)){
                return "a";
            }else {
                return s;
            }
        }
        char[] chars = s.toCharArray();

        for (int i = 0; i < length-1; i++) {
            if(chars[i]=='?'){
                if(i==0){
                    if(chars[i+1]=='?'){
                        chars[i] = 'a';
                    }else {
                        chars[i] = (chars[i+1]+1)>'z'?'a':(char) (chars[i+1]+1);
                    }
                }else {
                    chars[i] = (chars[i-1]+1)>'z'?'a':(char) (chars[i-1]+1);
                    if(chars[i]==chars[i+1]){
                        chars[i] = (chars[i+1]+1)>'z'?'a':(char) (chars[i+1]+1);
                    }
                }
            }
        }
        if(chars[length-1]=='?'){
            chars[length-1] = (chars[length-2]+1)>'z'?'a':(char) (chars[length-2]+1);
        }
        return new String(chars);
    }
}
