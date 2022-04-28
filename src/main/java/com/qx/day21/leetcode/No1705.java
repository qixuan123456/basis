package com.qx.day21.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Xuan
 * Date: 2021/12/24
 * Time: 12:53
 */
public class No1705 {

    public static void main(String[] args) {
        int[] apples = {1,2,3,5,2}, days = {3,2,1,4,2};
        System.out.println(eatenApples(apples,days));
    }
    public static int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int time = 0;
        int res = 0;
        while (time<days.length||!queue.isEmpty()){
            if(time< days.length){
                queue.add(new int[]{days[time]+time-1,apples[time]});
            }
            while (!queue.isEmpty()&&(queue.peek()[0]<time||queue.peek()[1]<=0)){
                queue.poll();
            }
            int[] s = queue.poll();
            if(s!=null&&s[0]>=time&&s[1]>0){
                queue.add(new int[]{s[0],--s[1]});
                res++;
            }
            time++;
        }
        return res;
    }
}
