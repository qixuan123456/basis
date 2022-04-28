package com.qx.day21.jingsai.no287;

/**
 * @author Xuan
 * Date: 2022/4/8
 * Time: 19:54
 */
public class No3 {
    public static void main(String[] args) {
        No3 no3 = new No3();
        int[] candies ={162,343,511,240,578,497,762,720,714,158,535,529,652,564,
                703,814,408,154,659,673,857,760,989,310,834,804,577,115,510,108,
                612,466,310,461,573,500,116,324,934,442,399,990,992,215,947,522,
                835,762,918,548,684,938,680,125,880,272,807,673,768,111,854,768,
                910,509,477,932,941,795,504,821,222,739,282,207,659,768,213,574,
                405,984,639,132,596,255,369,129,605,265,323,534,763,575,323,187,
                605,874,384,432,925,191};
        long k = 22;
        System.out.println(no3.maximumCandies(candies,k));
    }
    public int maximumCandies(int[] candies, long k) {
        int res = 0;
        int right = 0,left = 0;
        for (int candy : candies) {
            if (candy > right) {
                right = candy;
            }
        }
        while(left<=right){
            int mid = (left+right)/2;
            int a = 0;
            if(mid ==0){
                return 0;
            }
            for (int candy : candies) {
                a += candy / mid;
            }
            if(a<k){
                right = mid-1;
            }else if(a>k){
                left = mid+1;
                res = mid;
            }else {
                left++;
                res = mid;
            }
        }
        return res;
    }
}
