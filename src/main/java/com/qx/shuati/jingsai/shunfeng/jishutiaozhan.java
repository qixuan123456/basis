package com.qx.shuati.jingsai.shunfeng;

import java.util.*;

/**
 * @author xuan
 * @date 2022/6/20 13:03
 */
public class jishutiaozhan {
    public static void main(String[] args) {

        int[][] a = {{0,1,3,2}, {1,0,3,2}, {3,3,0,2},{2,2,2,0}};

        System.out.println(new jishutiaozhan().isCompliance(a,1));

    }
    Map<Integer, List<Integer>> map = new HashMap<>();
    boolean[] is = new boolean[100];
    public boolean hasCycle(String graph) {
        String[] s = graph.split("(,|->)");

        for (int i = 0; i < s.length/2; i++) {
            Integer a = Integer.parseInt(s[2*i]);
            Integer b = Integer.parseInt(s[2*i+1]);
            List<Integer> orDefault = map.getOrDefault(a, new ArrayList<>());
            orDefault.add(b);
            map.put(a, orDefault);
        }

        for (int i = 0; i < is.length; i++) {
            if(dfs(new boolean[100],i)){
                return true;
            }
        }

        return false;
    }

    public boolean dfs(boolean[] flag,Integer index){


        List<Integer> list = map.get(index);
        if(list==null){
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if(!flag[list.get(i)]){
                flag[list.get(i)]=true;
                is[list.get(i)] = true;
                if(dfs(flag,list.get(i))){
                    return true;
                }
                flag[list.get(i)]=false;
            }else {
                return true;
            }
        }
        return false;
    }


    public int minRemainingSpace(int[] N, int V) {
        int[][] dp = new int[N.length+1][V+1];
        for (int i = 1; i <= N.length; i++) {
            for (int j = 0; j <= V; j++) {
                if(j>=N[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-N[i-1]]+N[i-1]);
                }else {
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        return V - dp[N.length][V];
    }

    public int findMaxCI(int[] nums) {
        int ans = 0;
        for(int left=0;left<nums.length;){
            int right = left+1;
            while (right<nums.length&&nums[right]>nums[right-1]){
                right++;
            }
            ans = Math.max(ans,right-left);
            left = right;
        }
        return ans;
    }

    public boolean isCompliance(int[][] distance, int n) {
        int[] group = new int[distance.length];
        for(int i=0;i<distance.length;i++){
            group[i] = i;
        }
        Set<Integer> set = new HashSet<Integer>();

        for(int i=0;i<distance.length;i++){
            for(int j=0;j<distance[i].length;j++){
                if(distance[i][j]<=2){
                    union(i,j,group);
                }
            }
        }

        for(int i=0;i<distance.length;i++){
            System.out.println(group[i]);
            set.add(find(i,group));
        }
        System.out.println(set.size());
        return set.size()<=n;

    }

    public int find(int a,int[] group){
        if(a!=group[a]){
            a = find(group[a],group);
        }
        return group[a];
    }

    public void union(int a,int b,int[] group){
        a = find(a,group);
        b = find(b,group);

        group[b] = a;
    }
}
