package com.qx.day21.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xuan
 * Date: 2022/1/7
 * Time: 20:47
 */
public class No93 {

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("010010"));
    }
    public static List<List<String>> lists = new ArrayList<>();
    public static List<String> list = new ArrayList<>();
    public static List<String> restoreIpAddresses(String s) {
        if(s.length()>12||s.length()<4){
            return list;
        }
        dfs(s,0,s.length());
        list.clear();
        for (List<String> l : lists) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.append(l.get(i));
                if(i<3){
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        return list;
    }
    public static void dfs(String s,int start, int count){
        if(list.size()==4&&start==count){
            lists.add(new ArrayList<>(list));
        }
        for (int i = 1; i <= 3; i++) {
            if(start+i>count){
                break;
            }
            String sub = s.substring(start,start+i);
            int a = Integer.parseInt(sub);
            if(a==0){
                list.add(sub);
                dfs(s,start+i,count);
                list.remove(list.size()-1);
                break;
            } else if(a<256){
                list.add(sub);
                dfs(s,start+i,count);
                list.remove(list.size()-1);
            }
        }

    }

}
