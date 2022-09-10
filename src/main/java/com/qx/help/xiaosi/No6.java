package com.qx.help.xiaosi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            int target = n - One(i);
            if (target < 0) {
                continue;
            }
            for (int j = 0; j < 60; j++) {
                if (One(j) == target) {
                    ans.add(i + ":" + (j < 10 ? "0" : "") + j);
                }
            }
        }
        System.out.println(ans);
    }

    public static int One(int num) {
        int res = 0;
        for (int i = 0; i < 6; i++) {
            if (((num >> i) & 1) == 1) {
                res++;
            }
        }
        return res;
    }
}
