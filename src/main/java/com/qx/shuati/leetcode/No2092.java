package com.qx.shuati.leetcode;

import java.util.*;

/**
 * @author Xuan
 * Date: 2021/11/29
 * Time: 15:49
 */
public class No2092 {
    public static void main(String[] args) {
        int[][] meetings = {{3,1,3},{1,2,2},{0,3,3}};

        System.out.println(new No2092().findAllPeople(6,meetings,3));
    }



    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.add(firstPerson);
        Arrays.sort(meetings, (a,b)->a[2]-b[2]);
        int flag = 0;
        for (int i = 0; i < meetings.length; i++) {
            if(i>0&&meetings[i][2]!=meetings[i-1][2]){
                int k = i-1;
                while(k-flag>=0){
                    if(set.contains(meetings[k][0])||set.contains(meetings[k][1])){
                        set.add(meetings[k][0]);
                        set.add(meetings[k][1]);
                    }
                    k--;
                }
                flag = i;
            }
            if(set.contains(meetings[i][0])||set.contains(meetings[i][1])){
                set.add(meetings[i][0]);
                set.add(meetings[i][1]);
            }
        }
        if(flag==0){
            int k = meetings.length-1;
            while(k>=0){
                if(set.contains(meetings[k][0])||set.contains(meetings[k][1])){
                    set.add(meetings[k][0]);
                    set.add(meetings[k][1]);
                }
                k--;
            }
        }
        return new ArrayList<>(set);
    }
}
