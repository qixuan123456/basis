package com.qx.bishi.xiaohongshu.second;

import java.util.*;

/**
 * @author xuan
 * @date 2022/9/4 17:03
 */
public class No3 {

    public static List<Integer> ans = new ArrayList<>();
    public static int k;
    public static int[] f;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        k = scanner.nextInt();
        scanner.nextLine();
        int[] start = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] end = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        f = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i+1,new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            map.get(start[i]).add(new int[]{end[i],f[i]});
            map.get(end[i]).add(new int[]{start[i],f[i]});
        }
        boolean[] flags = new boolean[n];
        flags[0] = true;
        dfs(flags,map,1,0,0);
        System.out.println(ans.stream().min(Integer::compareTo).get());
    }

    public static void dfs(boolean[] flags,Map<Integer, List<int[]>> map,int current,int step,int max){
        if(step>k){
            return ;
        }
        if(current == flags.length){
            ans.add(max);
            return;
        }
        List<int[]> list = map.get(current);
        for (int i = 0; i < list.size(); i++) {
            int[] a = list.get(i);
            if(!flags[a[0]-1]){
                flags[a[0]-1] = true;
                dfs(flags,map,a[0],step+1,Math.max(max,a[1]));
                flags[a[0]-1] = false;
            }
        }
    }
}
