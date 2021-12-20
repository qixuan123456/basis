package day21.leetcode;

import java.util.Arrays;

/**
 * @author Xuan
 * Date: 2021/11/26
 * Time: 21:24
 */
public class No1404 {

    public static void main(String[] args) {

        System.out.println(new No1404().numSteps("1101"));
    }

    public int numSteps(String s) {
        int res = 0;
        char[] c = s.toCharArray();
        int flag = c.length-1;
        while(flag>0){
            if(c[flag]=='1'){
                c = addOne(c,flag);
            }else{
                flag--;
            }
            res++;
        }
        return res;
    }

    public char[] addOne(char[] c, int flag){
        int a = 1;
        for(int i = flag;i >= 0;i--){
            if(a == 1){
                if(c[i] == '1'){
                    c[i] = '0';
                }else{
                    c[i] = '1';
                    return c;
                }
            }else {
                return c;
            }
        }
        if(a == 1){
            char[] cc =  new char[c.length];
            Arrays.fill(cc,'0');
            cc[0] = '1';
            return cc;
        }
        return c;
    }
}
