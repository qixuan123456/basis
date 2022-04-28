package com.qx.day21.leetcode;

/**
 * @author Xuan
 * Date: 2021/12/1
 * Time: 20:07
 */
public class No1052 {

    public static void main(String[] args) {
        int[] customers={1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;
        No1052 no1052 = new No1052();
        System.out.println(no1052.maxSatisfied(customers,grumpy,minutes));
    }



    /**
     * 方法1
     * @param customers
     * @param grumpy
     * @param minutes
     * @return
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int res = 0;
        int max = 0;
        for (int i = 0; i < customers.length; i++) {
            if(i<minutes){
                res +=customers[i];
                continue;
            }
            if(grumpy[i]==0){
                res +=customers[i];
            }
        }
        max = Math.max(max,res);
        for (int i = 1; i < customers.length - minutes+1; i++) {
            if(grumpy[i-1]==1){
                res -= customers[i-1];
            }

            if(grumpy[i+minutes-1]==1){
                res +=customers[i+minutes-1];
            }
            max = Math.max(max,res);
        }

        return max;
    }
}
