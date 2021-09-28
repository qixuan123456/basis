package day21.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * User: xuan
 * Date: 2021/9/25
 * Time: 13:58
 */
public class No22 {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        gg(n,list,0,0,new StringBuilder());
        return list;
    }

    public static void gg(int n, List<String> lists, int a, int b, StringBuilder s){
        if(a==n&&b==n){
            lists.add(s.toString());
            return;
        }
        if(a<n){
            s.append('(');
            gg(n,lists,a+1,b,s);
            s.delete(s.length()-1,s.length());
        }
        if(a>b){
            s.append(')');
            gg(n,lists,a,b+1,s);
            s.delete(s.length()-1,s.length());
        }
    }
}
