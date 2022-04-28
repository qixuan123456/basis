package com.qx.day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author xuan
 * @date 2022/4/23 15:39
 */
public class No3 {

    public static void main(String[] args) throws IOException {
//        int[][] moles = new int[][] {{1,0,1},{2,0,0},{3,1,0},{4,2,0},{5,2,1},{8,2,2},{7,2,1},{9,2,1}};
//
//        System.out.println(solution(moles));

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(sc.readLine());
        while(T-->0){
            Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
            map.put(0,new PriorityQueue<>());
            map.put(1,new PriorityQueue<>());
            map.put(2,new PriorityQueue<>());
            int N = Integer.parseInt(sc.readLine());
            String a = sc.readLine();

            for (int i = 0; i < N; i++) {
                map.get(a.charAt(i)-'0').offer(i);
            }
            int n = Integer.parseInt(sc.readLine());

            char[] chars = sc.readLine().toCharArray();
            for (int i = 0; i < n; i++) {
                if(chars[i]=='M'){
                    if(!map.get(1).isEmpty()){
                        System.out.println(map.get(1).poll()+1);
                    }else if(!map.get(0).isEmpty()) {
                        int ans = map.get(0).poll();
                        map.get(1).offer(ans);
                        System.out.println(ans+1);
                    }else {
                        System.out.println(-1);
                    }
                }else {
                    if(!map.get(0).isEmpty()){
                        int ans = map.get(0).poll();
                        map.get(1).offer(ans);
                        System.out.println(ans+1);
                    }else if(!map.get(1).isEmpty()){
                        System.out.println(map.get(1).poll()+1);
                    }else {
                        System.out.println(-1);
                    }
                }
            }

        }




    }

    public static int solution(int[][] moles){
        Arrays.sort(moles,(a,b)->a[0]-b[0]);
        int maxTime = moles[moles.length-1][0];
        int[] dp = new int[maxTime+1];
        dp[0] = (moles[0][0]==0&&moles[0][1]==1&&moles[0][2]==1?1:0);
        int a = dp[0];

        for (int i = 1; i < maxTime+1; i++) {
            if(moles[a][0]>i){
                dp[i] = Math.max(dp[i-1],moles[a][0]>=Math.abs(moles[a][1]-1)+Math.abs(moles[a][2]-1)?1:0);
            }else {
                dp[i] = moles[a][0]>=Math.abs(moles[a][1]-1)+Math.abs(moles[a][2]-1)?1:0;
                for (int j = 0; j < a; j++) {
                    if(i>=moles[j][0]){
                        int d = Math.abs(moles[a][1]-moles[j][1])+Math.abs(moles[a][2]-moles[j][2]);
                        int t = Math.abs(moles[a][0]-moles[j][0]);
                        int c = t>=d?1:0;
                        dp[i] = Math.max(dp[i],dp[moles[j][0]]+c);
                    }
                }
                a++;
            }
        }
        return dp[maxTime];
    }
}
