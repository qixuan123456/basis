package com.qx.bishi.xiaohongshu;

import java.util.*;

/**
 * @author xuan
 * @date 2022/8/28 17:23
 */
public class No3 {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i,new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            map.get(nums[i]).add(i+2);
            map.get(i+2).add(nums[i]);
        }
        for (int i = 1; i <= n; i++) {
            bfs(i,map,new boolean[n]);
        }
        System.out.println(ans/2);
    }

    public static void bfs(int current,Map<Integer,List<Integer>> map,boolean[] flags){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(current);
        int length = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int poll = queue.poll();
                List<Integer> list = map.get(poll);
                for (int j = 0; j < list.size(); j++) {
                    if(!flags[list.get(i)-1]){
                        queue.add(list.get(i));
                        flags[list.get(i)-1] = true;
                    }
                }
            }
            length++;
        }
        ans = Math.max(length,ans);
    }
}
