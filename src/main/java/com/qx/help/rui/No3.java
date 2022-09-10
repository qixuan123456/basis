package com.qx.help.rui;

import java.util.*;

public class No3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            map.get(scanner.nextInt()).add(i + 1);
        }
        if(n>1){
            scanner.nextLine();
        }
        char[] chars = scanner.nextLine().toCharArray();
        int[] ans = new int[n];
        dfs(chars, 1, map, ans);
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.print(ans[i]);
            } else {
                System.out.print(" " + ans[i]);
            }
        }
    }

    public static Set<Character> dfs(char[] chars, int current, Map<Integer, List<Integer>> map, int[] ans) {
        Set<Character> res = new HashSet<>();
        List<Integer> list = map.get(current);
        for (int a : list) {
            res.addAll(dfs(chars, a, map, ans));
        }
        res.add(chars[current - 1]);
        ans[current - 1] = res.size();
        return res;
    }
}
