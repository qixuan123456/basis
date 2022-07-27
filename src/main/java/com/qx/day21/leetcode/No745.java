package com.qx.day21.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuan
 * @date 2022/7/14 20:34
 */
public class No745 {
    public static void main(String[] args) {
        No745 no745 = new No745();
        no745.WordFilter(new String[]{"c","c","c","c","i","c","c","c","c","i"});
        System.out.println(no745.f("c", "c"));
    }
    Map<String, List<Integer>> prefs = new HashMap<>();
    Map<String,List<Integer>> suffs = new HashMap<>();
    public void WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                String pref = words[i].substring(0,j+1);
                String suff = words[i].substring(j);
                List<Integer> list1 = prefs.getOrDefault(pref,new ArrayList<>());
                List<Integer> list2 = suffs.getOrDefault(suff,new ArrayList<>());
                list1.add(i);
                list2.add(i);
                prefs.put(pref,list1);
                suffs.put(suff,list2);
            }

        }
    }
    public int f(String pref, String suff) {
        List<Integer> list1 = prefs.get(pref);
        List<Integer> list2 = suffs.get(suff);
        if(list1!=null&&list2!=null){
            int index1 = list1.size()-1;
            int index2 = list2.size()-1;
            while(index1>=0&&index2>=0){
                int a = list1.get(index1);
                int b = list2.get(index2);
                if(a<b){
                    index2--;
                }else if(a>b){
                    index1--;
                }else {
                    return a;
                }
            }
        }
        return -1;
    }
}
