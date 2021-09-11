package day21.leetcode;

import java.util.Arrays;

public class No1833 {
    public static void main(String[] args) {
        int[] costs = {1,3,2,4,1};
        int coins= 0;
        int c = maxIceCream(costs,coins);
        System.out.println(c);
    }

    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int num=0;
        for(int i=0;i<costs.length;i++){
            num+=costs[i];
            if(num>coins){
                return i;
            }
        }
        return 0;
    }
}
