package com.qx.day21.leetcode;

/**
 * @author Xuan
 * Date: 2022/3/21
 * Time: 18:58
 */
public class No67 {
    public static void main(String[] args) {
        System.out.println(new No67().addBinary("1", "11111"));
    }

    public String addBinary(String a, String b) {

        int la = a.length();
        int lb = b.length();
        if(la<lb){
            String s = a;
            a = b;
            b = s;
        }
        char[] ans = new char[Math.max(la,lb)+1];
        int i = Math.max(la,lb)-1;
        int c = 0;
        int k = Math.abs(la - lb);
        while(i>=0){
            int aa = a.charAt(i)-'0';
            int bb;
            if(i-k<0){
                bb=0;
            }else {
                bb = b.charAt(i-k)-'0';
            }
            ans[i+1] = (char) ((aa+bb+c)%2+'0');
            c = (aa+bb+c)/2;
            i--;
        }
        ans[0] = (char) (c+'0');
        int x = 0;
        if(ans[0]=='0'){
            x = 1;
        }
        return new String(ans,x,a.length()+1-x);
    }
}
