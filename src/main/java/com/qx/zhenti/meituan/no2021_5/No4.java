package com.qx.zhenti.meituan.no2021_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author xuan
 * @date 2022/8/14 15:12
 */
public class No4 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        while (scanner.hasNext()){
            int n = Integer.parseInt(scanner.nextLine());

            int[] ints = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
            for (int i = 0; i < n; i++) {
                queue.add(ints[i]);
            }
            int target = n;
            while(!queue.isEmpty()){
                int poll = queue.poll();
                if(poll-1!=queue.size()){
                    System.out.println("NO");
                    break;
                }

            }
        }
    }
}
