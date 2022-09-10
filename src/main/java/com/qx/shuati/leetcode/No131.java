package com.qx.shuati.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuan
 * @date 2022/7/21 14:09
 */
public class No131 {

    List<List<String>> ans ;
    char[] chars;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        chars = s.toCharArray();
        dfs(new ArrayList<>(),-1);
        return ans;
    }

    public void dfs(List<String > list,int index){
        if(index==chars.length-1){
            ans.add(new ArrayList<>(list));
            return;
        }
        int current = index+1;
        for (int i = current; i < chars.length; i++) {
            if(check(chars,current,i)){
                list.add(new String(chars,current,i-current+1));
                dfs(list,i);
                list.remove(list.size()-1);
            }
        }
    }

    public boolean check(char[] chars,int start,int end){
        for (int i = 0; i <= (end-start)/2; i++) {
            if(chars[start+i]!=chars[end-i]){
                return false;
            }
        }
        return true;
    }
}
