package com.qx.bishi.meituan2;

import java.util.*;

/**
 * @author xuan
 * @date 2022/8/27 16:49
 */
public class No4 {

    public static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.nextLine();
        int[] p = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] t = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if(p[0]>b){
            System.out.println(-1);
            return;
        }
        List<Integer> list = new ArrayList<>();
        dfs(p,t,list,b-p[0],1);
        System.out.println(ans);
    }


    public static void dfs(int[] p, int[] t, List<Integer> list,int current,int index){
        if(index == p.length||current==0){
            solution(p,t,list);
            return;
        }
        if(p[index]>current){
            dfs(p,t,list,current,index+1);
        }else {
            list.add(index);
            dfs(p,t,list,current-p[index],index+1);
            list.remove(list.size()-1);
            dfs(p,t,list,current,index+1);
        }
    }

    public static void solution(int[] p, int[] t, List<Integer> list){
        int temp = 0;
        for (int i = 0; i < list.size()-1; i++) {
            temp = Math.max(temp,(list.get(i+1)*list.get(i))*t[list.get(i)]);
        }
        if(list.size()>0){
            temp = Math.max(temp,(p.length-list.get(list.size()-1))*t[list.get(list.size()-1)]);
        }
        if(temp>0){
            ans = Math.min(ans,temp);
        }
    }
}
