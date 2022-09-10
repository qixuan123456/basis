package com.qx.shuati.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author xuan
 * @date 2022/5/30 18:59
 */
public class No1452 {

    public static void main(String[] args) {
        int[] ints = IntStream.range(0, 10).toArray();
        System.out.println(Arrays.toString(ints));
    }

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if(i!=j&&favoriteCompanies.get(j).size()>favoriteCompanies.get(i).size()){
                    if(new HashSet<>(favoriteCompanies.get(j)).containsAll(favoriteCompanies.get(i))){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                ans.add(i);
            }
        }
        return ans;
    }
}
