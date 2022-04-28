package com.qx.day21.leetcode;

import java.util.*;

/**
 * @author Xuan
 * Date: 2021/11/10
 * Time: 14:55
 */
public class No51 {

    public static void main(String[] args) {
        No51 no51 = new No51();
        System.out.println(no51.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] genRes = new int[n];
        Arrays.fill(genRes,-1);
        Set<Integer> lie  = new HashSet<>();
        Set<Integer> youxie = new HashSet<>();
        Set<Integer> zuoxie = new HashSet<>();
        dfs(res,genRes,n,0,lie,youxie,zuoxie);
        return res;

    }
    public void dfs(List<List<String>> res,int[] genRes,int n ,int row ,Set<Integer> lie,Set<Integer> youxie,Set<Integer> zuoxie){
        if(row==n){
            res.add(gen(genRes));
            return;
        }

        for (int i = 0; i < n; i++) {
            if(lie.contains(i)){
                continue;
            }
            int you = row-i;
            if(youxie.contains(you)){
                continue;
            }
            int zuo = row+i;
            if(zuoxie.contains(zuo)){
                continue;
            }

            genRes[row] = i;
            lie.add(i);
            youxie.add(you);
            zuoxie.add(zuo);
            dfs(res,genRes,n,row+1,lie,youxie,zuoxie);
            zuoxie.remove(zuo);
            youxie.remove(you);
            lie.remove(i);
            genRes[row]=-1;
        }

    }
    public List<String> gen(int[] genRes){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < genRes.length; i++) {
            char[] res = new char[genRes.length];
            Arrays.fill(res,'.');
            res[genRes[i]]='Q';
            list.add(String.valueOf(res));
        }
        return list;
    }


}
