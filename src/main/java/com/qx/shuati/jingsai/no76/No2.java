package com.qx.shuati.jingsai.no76;

/**
 * @author xuan
 * @date 2022/4/21 19:46
 */
public class No2 {

    public static void main(String[] args) {
        System.out.println(waysToBuyPensPencils(20, 10,  5));
    }

    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {

        long a = total/cost1;
        long ans = 0L;
        for (long i = 0; i <= a; i++) {
            ans+= ((total-i*cost1)/cost2+1L);
        }
        return ans;
    }
}
