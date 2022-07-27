package com.qx.day21.jingsai;

import java.util.*;

/**
 * @author xuan
 * @date 2022/5/3 20:20
 */
public class No291 {

    public String removeDigit(String number, char digit) {
        String res = "";
        StringBuilder sb = new StringBuilder(number);
        for (int i = 0; i < sb.length(); i++) {
            if(number.charAt(i)==digit){
                String s = sb.deleteCharAt(i).toString();
                if(res.equals("")){
                    res = s;
                }else {
                    res = res.compareTo(s)>0?res:s;
                }
            }
            sb = new StringBuilder(number);
        }
        return res;
    }

    public int minimumCardPickup(int[] cards) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = -1;
        for (int i = 0; i < cards.length; i++) {
            if(map.containsKey(cards[i])){
                if(res ==-1){
                    res = i-map.get(cards[i])+1;
                }else {
                    res = Math.min(res,i-map.get(cards[i])+1);
                }
            }
            map.put(cards[i],i);
        }
        return res;
    }

    public int countDistinct(int[] nums, int k, int p) {
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            int a = 0;
            for (int j = i; j < nums.length; j++) {
                list.add(nums[j]);
                if(nums[j]%p==0){
                    a++;
                    if(a>k){
                        break;
                    }
                }
                set.add(new ArrayList<>(list));
            }
        }
        return set.size();
    }

    public long appealSum(String s) {
        long res = 0L;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                set.add(s.charAt(j));
                res += set.size();
            }

        }
        return res;
    }
}
