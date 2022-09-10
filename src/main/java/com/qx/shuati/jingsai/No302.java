package com.qx.shuati.jingsai;

import java.util.*;

/**
 * @author xuan
 * @date 2022/7/18 13:44
 */
public class No302 {

    public int[] numberOfPairs(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                ans[0]++;
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }
        }
        ans[1] = set.size();
        return ans;
    }



    public int maximumSum(int[] nums) {
        int[] temp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            temp[i] = getSum(nums[i]);
        }
        Map<Integer,Integer> map = new HashMap<>();
        int ans = -1;
        for (int i = 0; i < temp.length; i++) {
            if(map.containsKey(temp[i])){
                int g = map.get(temp[i]);
                ans = Math.max(ans,nums[i]+g);
                if(nums[i]>g){
                    map.put(temp[i],nums[i]);
                }
            }else {
                map.put(temp[i],nums[i]);
            }

        }
        return ans;
    }

    public int getSum(int num){
        int res = 0;
        while (num>0){
            res+=(num%10);
            num = num/10;
        }
        return res;
    }

    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            PriorityQueue<Node> queue = new PriorityQueue<>((a,b)->{
                if(!a.num.equals(b.num)){
                    return b.num.compareTo(a.num);
                }else{
                    return b.index- a.index;
                }});
            for (int j = 0; j < nums.length; j++) {

                queue.add(new Node(nums[j].substring(nums[0].length()-queries[i][1]),j));
                if(queue.size()>queries[i][0]){
                    queue.poll();
                }
            }
            ans[i] = queue.poll().index;
        }

        return ans;
    }
    static class Node{
        String num;
        int index;
        public Node(String num,int index){
            this.index = index;
            this.num = num;
        }
    }


    public static void main(String[] args) {
        int[] nums = {2,3,2,4,3};
        int[] queries = {9,6,9,3,15};
        System.out.println(minOperations(nums,queries));
    }
    public static int minOperations(int[] nums, int[] numsDivide) {
        int max ;

        if(numsDivide.length>1){
            max = gcf(numsDivide[0],numsDivide[1]);
        }else {
            max = numsDivide[0];
        }
        int ans = 0;
        for (int i = 1; i < numsDivide.length; i++) {
            max = gcf(max,numsDivide[i]);
        }
        Arrays.sort(nums);
        if(nums[0]>max){
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        double d = Math.sqrt(max);
        for (int i = 1; i <= d; i++) {
            if(max%i==0){
                set.add(i);
                set.add(max/i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                break;
            }else {
                ans++;
            }
        }
        return ans;
    }

    public static int gcf(int a,int b){
        if(b==0){
            return a;
        }
        return gcf(b,a%b);
    }
}
