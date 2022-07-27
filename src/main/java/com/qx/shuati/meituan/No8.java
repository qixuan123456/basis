package com.qx.shuati.meituan;

import java.util.*;

/**
 * @author xuan
 * @date 2022/5/11 12:59
 */
public class No8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            List<Integer> list1 = map.getOrDefault(start,new ArrayList<>());
            list1.add(end);
            List<Integer> list2 = map.getOrDefault(end,new ArrayList<>());
            list2.add(start);
            map.put(start,list1);
            map.put(end,list2);
        }
        Set<Integer> mSet = new HashSet<>();
        Set<Integer> tSet = new HashSet<>();
        List<Integer> mList = new ArrayList<>();
        List<Integer> tList = new ArrayList<>();
        mSet.add(M);
        tSet.add(T);
        mList.add(M);
        tList.add(T);
        int ans = 0;
        while(!mSet.containsAll(tSet)){
            List<Integer> mListNew = new ArrayList<>();
            List<Integer> tListNew = new ArrayList<>();
            for (Integer i:mList) {
                List<Integer> list = map.get(i);
                for (Integer j:list) {
                    if(!mSet.contains(j)){
                        mListNew.add(j);
                        mSet.add(j);
                    }
                }
            }

            for (Integer i:tList) {
                List<Integer> list = map.get(i);
                for (Integer j:list) {
                    if(!tSet.contains(j)){
                        tListNew.add(j);
                        tSet.add(j);
                    }
                }
            }
            mList = mListNew;
            tList = tListNew;
            ans++;
        }
        System.out.println(ans);
    }
}
