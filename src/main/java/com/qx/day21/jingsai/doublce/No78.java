package com.qx.day21.jingsai.doublce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xuan
 * @date 2022/5/14 22:25
 */
public class No78 {

    public static void main(String[] args) {
       // System.out.println(divisorSubstrings(240,2));

        int[][] a= {{1,1}};
        System.out.println(maximumWhiteTiles(a,1));
    }

    public static int divisorSubstrings(int num, int k) {
        int ans = 0;
        String s = String.valueOf(num);
        for(int i=0;i<s.length()-k+1;i++){
            int a = Integer.parseInt(s.substring(i,i+k));
            if(a!=0&&num%a==0){
                ans++;
            }
        }
        return ans;
    }

    public static int waysToSplitArray(int[] nums) {
        int length = nums.length;
        int ans = 0;
        long[] sum = new long[length];

        for (int i = 0; i < length; i++) {
            if(i==0){
                sum[i]=nums[i];
            }else {
                sum[i] = sum[i-1]+nums[i];
            }
        }
        for (int i = 0; i < length - 1; i++) {
            if(sum[length-1]-sum[i]<=sum[i]){
                ans++;
            }
        }
        return ans;
    }

    public static int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }else{
                return a[0]-b[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        list.add(tiles[0]);
        for (int i = 1; i < tiles.length; i++) {
            int[] a = list.get(list.size()-1);
            if(a[1]-a[0]+1>=carpetLen){
                return carpetLen;
            }
            if(tiles[i][0]>a[1]){
                list.add(tiles[i]);
            }else{
                if(tiles[i][1]>=a[1]){
                    continue;
                }
                a[1]=tiles[i][1];
            }
        }
        int ans = 0;
        int cur = 0;
        int l = 0;
        for (int i = 0; i < list.size(); i++) {
            if(i>0){
                cur = cur-(list.get(i-1)[1]-list.get(i-1)[0]+1);
            }
            int[] a = list.get(i);
            int b = a[0]+carpetLen-1;


            for (; l < list.size(); l++) {
                int[] aa = list.get(l);
                if(b<=aa[1]){
                    break;
                }
                cur+=aa[1]-aa[0]+1;
            }
            int add = 0;
            if(l<list.size()&&b>=list.get(l)[0]){
                add=(b-list.get(l)[0]+1);
            }
            ans = Math.max(ans,cur+add);
        }
        return ans;
    }




















}
