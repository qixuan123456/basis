package com.qx.shuati.leetcode;

import java.util.Random;

/**
 * @author xuan
 * @date 2022/6/5 14:40
 */
public class No478 {

    public static void main(String[] args) {

    }

    static class Solution{
        public double radius;
        public double x_center;
        public double y_center;
        public Random random;
        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.x_center = x_center;
            this.y_center = y_center;
            this.random = new Random();
        }

        public double[] randPoint() {
            double a = random.nextDouble();
            double b = random.nextDouble();
            double[] result = new double[2];
            result[0] = x_center+a*radius*Math.cos(Math.PI*2*b)*Math.sqrt(a);
            result[1] = y_center+a*radius*Math.sin(Math.PI*2*b)*Math.sqrt(a);
            return result;
        }
    }
}
