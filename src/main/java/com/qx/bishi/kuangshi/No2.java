package com.qx.bishi.kuangshi;

import java.util.Arrays;
import java.util.Scanner;

public class No2 {

    public static int[] bugSort(int arrLen, int[] arr, int splitLen, int[] splitArr) {
        int[] result = new int[arrLen];

        for (int s = 0; s < splitLen; s++) {
            // 1, 找到参照物
            int split = splitArr[s];
            result[split - 1] = split;

            // 2, 目标数组
            int curMin = 0;
            int curMax = split;
            for (int i = 0; i != arrLen; i++) {
                if (arr[i] < split) {
                    result[curMin++] = arr[i];
                } else if (arr[i] > split) {
                    result[curMax++] = arr[i];
                }
            }
            System.arraycopy(result, 0, arr, 0, arrLen);
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int arrLen = Integer.parseInt(scanner.nextLine());
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int splitLen = Integer.parseInt(scanner.nextLine());
        int[] splitArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] res = bugSort(arrLen, arr, splitLen, splitArr);
        System.out.println(Arrays.toString(res));
    }
}
