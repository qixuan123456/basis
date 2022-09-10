package com.qx.shuati.jingsai.no250;

public class No2 {
    public static void main(String[] args) {
        int[] rungs = {1,3,5,10};
        int dist = 2;
        System.out.println(addRungs(rungs,dist));
    }
    public static int addRungs(int[] rungs, int dist) {
        int min = 0;
        for (int i = 0; i < rungs.length; i++) {
            if(i==0){
                if(rungs[i]>dist)
                    min += (rungs[i]-1)/dist;
            }else if(rungs[i]-rungs[i-1]>dist){
                min += (rungs[i]-rungs[i-1]-1)/dist;
            }
        }
        return min;
    }
}
