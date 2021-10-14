package day21.leetcode;

import java.util.Arrays;

/**
 * User: xuan
 * Date: 2021/9/29
 * Time: 15:11
 */
public class No517 {

    public static void main(String[] args) {
        int[] machines = {0, 3, 0};
        System.out.println(findMinMoves(machines));

    }

    public static int findMinMoves(int[] machines) {
        int max = 0;
        int t = 0;
        for (int machine : machines) {
            t += machine;
        }
        int len = machines.length;
        if (t % len != 0) {
            return -1;
        }
        int a = t / len;
        int ls = 0, rs = t;
        for (int i = 0; i < machines.length; i++) {
            rs -= machines[i];
            int b = Math.max(0, i * a - ls);
            int c = Math.max(0, (len - i - 1) * a - rs);
            max = Math.max(b + c, max);
            ls += machines[i];
        }
        return max;
    }
}
