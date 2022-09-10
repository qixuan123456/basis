package com.qx.zhenti.meituan.no2021_1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/6/29 15:13
 */
public class No2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double sum = 0;
        int count = 0;
        for (int i = 1; i <= 5; i++) {
            int temp = sc.nextInt();
            sum += (temp) * i;
            count += temp;
        }
        BigDecimal a = new BigDecimal(sum/count);

        System.out.println(a.setScale(1,RoundingMode.DOWN));
    }
}
