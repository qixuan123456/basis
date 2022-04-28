package com.qx.day19;

import java.util.HashSet;

public class SetTest {


    public static void main(String[] args) {
        HashSet<Integer> a = new HashSet<Integer>();
        int[] b ={1,2,3,4,2,1,3};
        for (int i=0;i<7;i++){
            boolean p = a.add(b[i]);
            if(!p){
                a.remove(b[i]);
            }
        }
        System.out.println(a.iterator().next());
    }


}
