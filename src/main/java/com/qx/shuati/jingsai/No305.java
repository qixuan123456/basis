package com.qx.shuati.jingsai;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xuan
 * @date 2022/8/10 20:07
 */
public class No305 {

    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {

                int a = nums[j] - nums[i];
                if (a < diff) {
                    continue;
                } else if (a > diff) {
                    break;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    int b = nums[k] - nums[j];
                    if (b < diff) {
                        continue;
                    } else if (b > diff) {
                        break;
                    } else {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        int ans = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> set = new HashSet<>();

        for (int r : restricted) {
            set.add(r);
        }

        Queue<Integer> queue = new LinkedList<>();
        if (set.add(0)) {
            queue.add(0);
            ans++;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                List<Integer> list = map.get(poll);
                for (int l : list) {
                    if (set.add(l)) {
                        queue.add(l);
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(validPartition(new int[]{4, 4, 4, 5, 6}));
    }

    public static boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] flag = new boolean[n + 1];
        flag[0] = true;
        for (int i = 2; i <= n; i++) {

            if(i==2){
                flag[i] =  nums[i] == nums[i - 1];
                continue;
            }
            flag[i] = (flag[i - 2] && nums[i-1] == nums[i - 2])
                    || (flag[i - 3] && nums[i-1] == nums[i - 2] && nums[i-1] == nums[i - 3])
                    || (flag[i - 3] && nums[i-1] == nums[i - 2] + 1 && nums[i-1] == nums[i - 3] + 2);
        }
        return flag[n];
    }

    public int longestIdealString(String s, int k) {

        return 1;
    }
}
