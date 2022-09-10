package com.qx.bishi.xiecheng;

import java.util.*;

/**
 * @author xuan
 * @date 2022/8/30 19:17
 */
public class No3 {

    public static int ans = 0;
    public static int[] z = new int[3];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'r') {
                z[0]++;
            }
            if (c == 'g') {
                z[1]++;
            }
            if (c == 'b') {
                z[2]++;
            }
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i,new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            int a1 = scanner.nextInt();
            int a2 = scanner.nextInt();
            map.get(a1).add(a2);
            map.get(a2).add(a1);
        }
        boolean[] flags = new boolean[n+1];
        flags[1] = true;
        dfs(map,flags,1,s.toCharArray());
        System.out.println(ans);
    }

    public static int[] dfs(Map<Integer,List<Integer>> map,boolean[] flags, int current,char[] s){

        List<Integer> list = map.get(current);
        int[] res = new int[3];
        for (int i = 0; i < list.size(); i++) {
            int next = list.get(i);
            if(!flags[next]){
                flags[next] = true;
                int[] r = dfs(map,flags,next,s);
                if(r[0]>0&&r[1]>0&&r[2]>0&&z[0]-r[0]>0&&z[1]-r[1]>0&&z[2]-r[2]>0){
                    ans++;
                }
                res[0] += r[0];
                res[1] += r[1];
                res[2] += r[2];
            }
        }
        if(s[current-1]=='r'){
            res[0]++;
        }
        if(s[current-1]=='g'){
            res[1]++;
        }
        if(s[current-1]=='b'){
            res[2]++;
        }
        return res;
    }
}
