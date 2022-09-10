package com.qx.zhenti.niuke.mokao2021_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * @author xuan
 * @date 2022/7/15 18:56
 */
public class No3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Magical_NN(new int[]{3,1,4,5,3})));
    }
    public static int[] Magical_NN (int[] h) {
        // write code here

        int[] ints = IntStream.range(0, h.length).boxed().sorted(Comparator.comparingInt(a -> h[a])).mapToInt(Integer::intValue).toArray();
        Arrays.sort(h);
        int[] ans = new int[h.length];
        int[] pref = new int[h.length];
        int sum = 0;
        for (int i = 0; i < pref.length; i++) {
            sum += h[i];
            pref[i] = sum;
        }
        for (int i = 0; i < ans.length; i++) {
            int a = 0;
            if(i!=0){
                a = pref[i-1];
            }
            ans[ints[i]] = pref[h.length-1]-pref[i] - h[i]*(h.length-1-i) + i*h[i]- a;
        }
        return ans;
    }
}
