package com.qx.day21.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author xuan
 * @date 2022/5/27 11:12
 */
public class No6043 {

    public static void main(String[] args) {
        Integer[] integers = IntStream.range(0, 5).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(integers));
    }
}
