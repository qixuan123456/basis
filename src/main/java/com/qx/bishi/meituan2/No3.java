package com.qx.bishi.meituan2;

import java.util.*;

/**
 * @author xuan
 * @date 2022/8/27 16:23
 */
public class No3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        String S = scanner.nextLine();

        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] ss = new String[m];
        for (int i = 0; i < m; i++) {
            ss[i] = scanner.nextLine();
        }
        int sum = Arrays.stream(nums).sum();
        if(sum!=n){
            System.out.println(0);
            return;
        }
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        dfs(S,ss,0,new StringBuilder(),new boolean[m],set,0);
        System.out.println(set.size());
    }


    public static void dfs(String S , String[] ss,int a, StringBuilder sb, boolean[] flags, Set<Integer> set,int l){
        if(S.equals(sb.toString())){
            set.add(a);
            return;
        }
        for (int i = 0; i < ss.length; i++) {
            if(!flags[i]) {
                flags[i] = true;
                sb.append(ss[i]);
                a = a|(1<<(l+ss[i].length()));
                dfs(S, ss, a, sb, flags,set,l+ ss[i].length());
                sb.delete(sb.length()-ss[i].length(),sb.length());
                a = a&~(1<<(l+ss[i].length()));
                flags[i] = false;
            }
        }
    }
}
