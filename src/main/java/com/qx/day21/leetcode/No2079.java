package com.qx.day21.leetcode;

/**
 * @author Xuan
 * Date: 2021/12/21
 * Time: 21:21
 */
public class No2079 {
    public static void main(String[] args) {
        int[] plants = {2,1,1,1,4,4};
        int capacity = 5;
        System.out.println(wateringPlants(plants,capacity));
    }
    public static int wateringPlants(int[] plants, int capacity) {
        int current = capacity;
        int res = 0;
        for(int i=0;i<plants.length;i++){
            while(plants[i]!=0){
                if(plants[i]>current){
                    current = capacity;
                    res+=2*i;
                }else if(plants[i]==current){
                    if(i!=plants.length-1){
                        res+=2*(i+1);
                        current = capacity;
                    }
                    plants[i]=0;
                }else{
                    current -= plants[i];
                    plants[i]=0;
                }
            }
        }
        return res+plants.length;
    }
}
