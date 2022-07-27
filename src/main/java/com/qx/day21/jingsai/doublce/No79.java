package com.qx.day21.jingsai.doublce;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author xuan
 * @date 2022/5/29 13:01
 */
public class No79 {


    public boolean digitCount(String num) {
        int[] nums = new int[10];
        for (int i = 0; i < num.length(); i++) {
            nums[num.charAt(i)-'0']++;
        }
        for (int i = 0; i < num.length(); i++) {
            if(num.charAt(i)-'0'!=nums[i]){
                return false;
            }
        }
        return true;
    }


    public String largestWordCount(String[] messages, String[] senders) {
        Map<String,Integer> map = new HashMap<>();
        String ans = null;
        int length = 0;
        for (int i = 0; i < senders.length; i++) {
            map.put(senders[i],1);
        }
        for (int i = 0; i < messages.length; i++) {
            int l = messages[i].split(" ").length;
            int newLength = map.get(senders[i])+l;
            if(newLength>length){
                ans = senders[i];
                length = newLength;
            }else if(newLength==length){
                if(senders[i].compareTo(ans)>0){
                    ans = senders[i];
                }
            }
            map.put(senders[i],map.get(senders[i])+l);
        }
        return ans;
    }

    public long maximumImportance(int n, int[][] roads) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < roads.length; i++) {
            map.put(roads[i][0],map.getOrDefault(roads[i][0],0)+1);
            map.put(roads[i][1],map.getOrDefault(roads[i][1],0)+1);
        }
        long ans = 0;
        int[] ints = map.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).mapToInt(Map.Entry::getValue).toArray();
        for (int anInt : ints) {
            ans += (long) anInt * n;
            n--;
        }
        return ans;
    }


    public static void main(String[] args) {

        BookMyShow bookMyShow = new BookMyShow(5,9);

        System.out.println(Arrays.toString(bookMyShow.gather(10,1)));
        System.out.println(bookMyShow.scatter(3,3));
        System.out.println(Arrays.toString(bookMyShow.gather(9,1)));
        System.out.println(Arrays.toString(bookMyShow.gather(10,2)));
        System.out.println(Arrays.toString(bookMyShow.gather(2,0)));
    }


    static class BookMyShow {
        private int n,m;
        private int can;
        private int[] p;
        public BookMyShow(int n, int m) {
            this.n = n;
            this.m = m;
            this.can = 0;
            p = new int[n];
        }

        public int[] gather(int k, int maxRow) {
            if(k>m){
                return new int[]{};
            }
            for (int i = can; i <= maxRow; i++) {
                int a = p[i];
                if(p[i]+k<=m){
                    p[i] = p[i]+k;
                    return new int[]{i,a};
                }
            }
            return new int[]{};
        }

        public boolean scatter(int k, int maxRow) {
            long sum = 0;
            for (int i = can; i <= maxRow; i++) {
                sum +=(m-p[i]);
                if(sum>k){
                    break;
                }
            }
            if(sum<k){
                return false;
            }else{
                for (int i = can; i <= maxRow&&k>0; i++) {
                    int c = m-p[i];
                    if(k-c>0){
                        p[i] = m;
                        k = k-c;
                    }else {
                        p[i] = p[i]+k;
                        k = 0;
                    }
                    if(p[i]==m&&can==i){
                        can++;
                    }
                }
            }
            return true;
        }
    }
}
