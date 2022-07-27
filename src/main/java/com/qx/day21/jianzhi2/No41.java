package com.qx.day21.jianzhi2;

/**
 * @author xuan
 * @date 2022/7/20 21:05
 */
public class No41 {

    public static void main(String[] args) {

    }
    int size;
    double sum = 0;
    int[] nums;
    int index = 0;
    public No41(int size){
        this.size = size;
        nums = new int[size];
    }
    public double next(int val) {
        sum -= nums[index%size];
        nums[index%size] = val;
        sum += val;
        index++;
        return sum/(Math.min(size,index));
    }
}
