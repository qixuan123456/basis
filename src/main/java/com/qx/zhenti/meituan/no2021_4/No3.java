package com.qx.zhenti.meituan.no2021_4;

import java.util.*;

/**
 * @author xuan
 * @date 2022/8/13 12:57
 */
public class No3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] nums = new int[n][];
        for (int i = 0; i < n; i++) {
            nums[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(set.add(nums[i][j])){
                    break;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>(set);

        for (int i = 0; i < n - 1; i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.print(list.get(n-1));
    }
}
