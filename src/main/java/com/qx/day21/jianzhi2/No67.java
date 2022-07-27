package com.qx.day21.jianzhi2;

/**
 * @author xuan
 * @date 2022/7/4 16:28
 */
public class No67 {
    public int strToInt(String str) {
        long ans = 0;
        boolean flag = true;
        boolean start = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c==' '){
                if(start){
                    break;
                }
            }else if(c=='+'){
                if(!start){
                    start = true;
                }else {
                    break;
                }
            }else if(c=='-'){
                if(!start){
                    start = true;
                }else {
                    break;
                }
                flag = false;
            }else if(!Character.isDigit(c)){
                break;
            }else {
                start = true;
                ans = ans*10+(c-'0');
                if(flag&&ans>Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                if(!flag&&-ans<Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }
        }

        if(!flag){
            ans = -ans;
        }
        return (int)ans;
    }
}
