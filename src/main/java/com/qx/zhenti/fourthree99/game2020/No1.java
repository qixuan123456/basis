package com.qx.zhenti.fourthree99.game2020;

import javafx.scene.transform.Scale;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/18 15:49
 */
public class No1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double height = 100;
        double sum = 0;

        while (n-->0){
            sum+= 2*height;
            height = height/2;

        }
        System.out.printf("%.6f %.6f",sum-100,height);
    }
}
