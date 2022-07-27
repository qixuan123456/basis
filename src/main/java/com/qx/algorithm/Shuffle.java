package com.qx.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author xuan
 * @date 2022/6/22 15:18
 *  洗牌算法
 */
public class Shuffle {

    private int[] nums;
    private Random random;

    public Shuffle(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public void doShuffle(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            int r = random.nextInt(n);
            int a = nums[i];
            nums[i] = nums[r];
            nums[r] = a;
            n--;
        }
    }

    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle(new int[]{1,2,3,4,5});
        shuffle.doShuffle(shuffle.nums);
        System.out.println(Arrays.toString(shuffle.nums));
    }
}
