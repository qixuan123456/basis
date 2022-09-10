package com.qx.help.qianggang;

import java.util.regex.Pattern;

/**
 * @author xuan
 * @date 2022/9/2 19:46
 */
public class No2 {

    public static void main(String[] args) {
        System.out.println(solution("hello word", "a"));
    }

    public static int solution(String s1,String s2){
        String replace = s2.replace('*', '.');
        replace = new StringBuilder(replace).reverse().toString();
        String[] ss = s1.split(replace,2);
        if(ss.length>1){
            return ss[0].length()+s2.length()-1;
        }
        return -1;
    }
}
