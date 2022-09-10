package com.qx.shuati.leetcode;

import java.util.PriorityQueue;

/**
 * @author xuan
 * @date 2022/4/25 19:38
 */
public class No313 {
    public static void main(String[] args) {

        Integer a = 127;
        Integer b = 128;
        System.out.println(a==new Integer(127));
        int[] primes = {2,7,13,19};
        System.out.println(nthSuperUglyNumber(12,primes));
    }
    //超时
    public static int nthSuperUglyNumber(int n, int[] primes) {
        if(n==1){
            return 1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<primes.length;i++){
            queue.offer(primes[i]);
        }
        int ans = 0;
        for(int i=1;i<n;i++){
            ans = queue.poll();
            for(int j=0;j<primes.length;j++){
                if(!queue.contains(ans*primes[j])){
                    queue.offer(ans*primes[j]);
                }
            }

        }
        return ans;
    }
}
