package com.qx.help.xiaosi;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/20 11:02
 */
public class No2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)-> (b[0]*100-b[0]*b[1])-(a[0]*100-a[0]*a[1]));
        int[] p = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] a = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < n; i++) {

            queue.add(new int[]{a[i],p[i]});
        }
        double ans = 0;
        for (int i = 0; i < n; i++) {
            int[] poll = queue.poll();
            if(i<m){
                ans+=poll[0];
            }else {
                ans+=(poll[0]*poll[1]/100.0);
            }
        }
        System.out.printf("%.2f",ans);
    }
}
