package com.qx.day24.lambdatest;

import java.util.Arrays;

public class LambdaTest {
    public static void main(String[] args) {
        String[] array = new String[] { "apple", "orange", "Banana", "Lemon" };
        Arrays.sort(array,(a,b)->a.toUpperCase().compareTo(b.toUpperCase()));
        System.out.println(String.join(",",array));
    }

}
