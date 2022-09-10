package com.qx.shuati.jingsai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xuan
 * @date 2022/5/15 16:01
 */
public class No293 {

    public static void main(String[] args) {
        No293 no293 = new No293();

//[[],[616,659],[913,936],[],[6,97],[],[],[],[949,967],[315,942],[380,484],[66,172],[737,877],[],[],[],[],[],[107,461],[498,911],[94,337],[603,663],[],[]
        no293.add(616, 659);
        no293.add(913, 936);
        System.out.println(no293.count());
        no293.add(6, 97);
        System.out.println(no293.count());
        System.out.println(no293.count());
        System.out.println(no293.count());
        no293.add(949, 967);
        no293.add(315, 942);
        no293.add(380, 484);
        no293.add(66, 172);
        no293.add(737, 877);
        System.out.println(no293.count());
        System.out.println(no293.count());
        System.out.println(no293.count());
        System.out.println(no293.count());
        no293.add(107, 461);
        no293.add(498, 911);
        no293.add(94, 337);
        no293.add(603, 606);

        System.out.println(no293.count());
        System.out.println(no293.count());
    }

    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        int[] current = check(words[0]);
        ans.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            int[] chars = check(words[i]);
            for (int j = 0; j < 26; j++) {
                if (chars[j] != current[j]) {
                    ans.add(words[i]);
                    current = chars;
                    break;
                }
            }
        }
        return ans;
    }

    public int[] check(String s) {
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 'a']++;
        }
        return res;
    }


    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int ans = Math.max(special[0] - bottom, top - special[special.length - 1]);
        for (int i = 1; i < special.length; i++) {
            int a = special[i] - special[i - 1] - 1;
            ans = Math.max(a, ans);

        }
        return ans;
    }


    public int largestCombination(int[] candidates) {
        int[] ans = new int[32];
        for (int candidate : candidates) {
            for (int j = 0; candidate > 0; j++) {
                ans[j] += (candidate & 1);
                candidate = candidate >> 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = Math.max(res, ans[i]);
        }
        return res;
    }


    List<int[]> list = new ArrayList<>();
    public boolean flag =false;
    public int ans1 = 0;
    public void add(int left, int right) {
        flag = false;
        if (list.isEmpty() || left > list.get(list.size() - 1)[1] + 1) {
            list.add(new int[]{left, right});
            return;
        }
        int l = 0, r = 0;


        for (int i = 0; i < list.size(); i++) {
            int[] arr = list.get(i);
            if (left <= arr[1] + 1) {
                l = i;
                if (right < arr[0] - 1) {
                    list.add(i, new int[]{left, right});
                    return;
                }
                if (left < arr[0]) {
                    arr[0] = left;
                }
                if (right < arr[1] + 1) {
                    return;
                } else {
                    while (true) {
                        if (i + 1 == list.size()) {
                            arr[1] = Math.max(right,arr[1]);
                            return;
                        }
                        int[] arr1 = list.get(i + 1);
                        if (right < arr1[0] - 1) {
                            arr[1] = Math.max(right,arr[1]);
                            return;
                        } else {
                            arr[1] = arr1[1];
                            list.remove(i + 1);
                        }
                    }
                }

            }

        }
    }


    public int count() {
        int ans = 0;
        if(flag){
            return ans1;
        }
        for (int i = 0; i < list.size(); i++) {
            int[] ints = list.get(i);
            ans += (ints[1] - ints[0] + 1);
        }
        flag = true;
        ans1 = ans;
        return ans1;
    }
}
