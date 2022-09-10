package com.qx.bishi.qqmusic;

import java.util.*;

/**
 * @author xuan
 * @date 2022/9/8 19:11
 */
public class No1 {

    public static void main(String[] args) {
        System.out.println(minOperations("aabb"));
    }
    public static int minOperations(String str) {
        // write code here
        PriorityQueue<int[]> queue1 = new PriorityQueue<>((a,b)->a[1]-b[1]);
        PriorityQueue<int[]> queue2 = new PriorityQueue<>((a,b)->b[1]-a[1]);
        int[] chars = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            chars[c-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            int[] num = new int[]{i,chars[i]};
            queue1.add(num);
            queue2.add(num);
        }
        int ans = 0;
        while(!queue2.isEmpty()&&queue2.peek()[1]>=2&&queue1.peek()[1]==0){
            int[] poll1 = queue1.poll();
            int[] poll2 = queue2.poll();
            poll2[1]-=2;
            poll1[1]++;
            queue1.add(poll1);
            queue2.add(poll2);
            ans++;
        }

        while(!queue1.isEmpty()){
            int a = queue1.poll()[1]-1;
            if(a>0){
                ans+=a;
            }
        }
        return ans;
    }
}
