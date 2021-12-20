package day21.leetcode;

import java.util.Arrays;

/**
 * @author Xuan
 * Date: 2021/12/20
 * Time: 12:22
 */
public class No475 {

    public static void main(String[] args) {
        int[] houses = {25921153,510616708};
        int[] heaters = {771515668,357571490,44788124,927702196,952509530};
        System.out.println(findRadius(houses,heaters));

    }

    public static int findRadius(int[] houses, int[] heaters) {

        int min = 0;
        Arrays.sort(heaters);
        for (int i = 0; i < houses.length; i++) {
            min = Math.max(min,find(houses[i],heaters));
        }
        return min;
    }

    public static int find(int a,int[] heaters){

        if(a>=heaters[heaters.length-1]){
            return a-heaters[heaters.length-1];
        }
        if(a<=heaters[0]){
            return heaters[0]-a;
        }
        int left = 0;
        int right = heaters.length-1;
        int cur = (right-left+1)/2+left;
        while (left<right){
            if(right-left==1){
                return Math.min(heaters[right]-a,a-heaters[left]);
            }
            if(heaters[cur]==a){
                return 0;
            }else if (heaters[cur]>a){
                right=cur;
            }else {
                left=cur;
            }
            cur = (right-left+1)/2+left;
        }
        return 0;
    }

}
