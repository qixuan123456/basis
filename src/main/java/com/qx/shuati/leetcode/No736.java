package com.qx.shuati.leetcode;

import java.util.*;

/**
 * @author xuan
 * @date 2022/7/6 10:19
 */
public class No736 {

    public static void main(String[] args) {
        System.out.println(new No736().evaluate("(let x 3 x 2 22)"));
    }
    public int evaluate(String expression) {
        return dfs(expression,new HashMap<>());
    }

    public int dfs(String expression,Map<String,Integer> map){
        List<String > strings = splits(expression);
        Map<String,Integer> temp = new HashMap<>(map);
        if(strings.get(0).equals("let")){
            for (int i = 1; i < strings.size() - 1; i+=2) {
                temp.put(strings.get(i),dfs(strings.get(i+1),temp));
            }
            return dfs(strings.get(strings.size()-1),temp);
        }else if(strings.get(0).equals("add")) {
            return dfs(strings.get(1),temp)+dfs(strings.get(2),temp);
        }else if(strings.get(0).equals("mult")){
            return dfs(strings.get(1),temp)*dfs(strings.get(2),temp);
        }else{
            int a;
            if(map.containsKey(strings.get(0))){
                a = map.get(strings.get(0));
            }else {
                a = Integer.parseInt(strings.get(0));
            }
            return a;
        }
    }

    public List<String> splits(String s){
        List<String> res = new ArrayList<>();
        int flag = 0;
        if(s.charAt(0)!='('){
            res.add(s);
            return res;
        }
        int pre = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('){
                flag++;
            }else if(c==')'){
                flag--;
            }else if(flag==1&&c==' ') {
                res.add(s.substring(pre,i));
                pre = i+1;
            }
            if(flag==0){
                res.add(s.substring(pre,i));
            }
        }
        return res;
    }
}
