package com.qx.bishi.shenxinfu;

/**
 * @author xuan
 * @date 2022/9/1 19:52
 */
public class No1 {

    public int reverse(int input_int) {
        // write code here

        StringBuilder sb = new StringBuilder();
        sb.append(input_int);
        return Integer.parseInt(sb.reverse().toString());
    }
}
