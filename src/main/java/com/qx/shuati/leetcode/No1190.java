package com.qx.shuati.leetcode;

/**
 * @author xuan
 * @date 2022/5/9 16:05
 */
public class No1190 {
    public static void main(String[] args) {
        System.out.println(new No1190().reverseParentheses("(u(love)i)"));
    }
    public String reverseParentheses(String s) {
        return reverse(s.toCharArray(),0,s.length()-1).toString();
    }

    public StringBuilder reverse(char[] chars ,int start,int end){
        StringBuilder sb = new StringBuilder();
        for(int i=start;i<=end;i++){
            if(chars[i]=='('){
                int n = 1;
                int s = i+1;
                while (n!=0&&i<=end){
                    if(chars[i+1]==')'){
                        n--;
                    }else if(chars[i+1]=='('){
                        n++;
                    }
                    i++;
                }
                sb.append(reverse(chars,s,i-1));
            }else {
                sb.append(chars[i]);
            }
        }
        return sb.reverse();
    }
}
