package com.qx.bishi.weilai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/5 19:50
 */
public class No4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(diff(scanner.nextLine()));
    }

    static final int ADDITION = -1;
    static final int SUBTRACTION = -2;
    static final int MUL = -3;

    public static List<Integer> diff(String exp){
        List<Integer> ops = new ArrayList<>();
        for (int i = 0; i < exp.length();) {
            if(!Character.isDigit(exp.charAt(i))){
                if(exp.charAt(i)=='+'){
                    ops.add(ADDITION);
                }else if(exp.charAt(i)=='-'){
                    ops.add(SUBTRACTION);
                }else {
                    ops.add(MUL);
                }
                i++;
            }else {
                int t = 0;
                while (i<exp.length()&&Character.isDigit(exp.charAt(i))){
                    t = t*10+exp.charAt(i)-'0';
                    i++;
                }
                ops.add(t);
            }
        }
        List<Integer>[][] dp = new ArrayList[ops.size()][ops.size()];
        for (int i = 0; i < ops.size(); i++) {
            for (int j = 0; j < ops.size(); j++) {
                dp[i][j] = new ArrayList<>();
            }
        }
        return dfs(dp,0,ops.size()-1,ops);
    }

    public static List<Integer> dfs(List<Integer>[][] dp,int l,int r,List<Integer> ops){
        if(dp[l][r].isEmpty()){
            if(l==r){
                dp[l][r].add(ops.get(l));
            }else {
                for (int i = l; i < r; i+=2) {
                    List<Integer> left = dfs(dp,l,i,ops);
                    List<Integer> right = dfs(dp,i+2,r,ops);
                    for (int ll : left) {
                        for (int rr : right) {
                            if(ops.get(i+1)==ADDITION){
                                dp[l][r].add(ll+rr);
                            }else if(ops.get(i+1)==SUBTRACTION){
                                dp[l][r].add(ll-rr);
                            }else {
                                dp[l][r].add(ll*rr);
                            }
                        }
                    }

                }
            }
        }
        return dp[l][r];
    }
}
