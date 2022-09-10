package com.qx.bishi.meituan2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/27 17:13
 */
public class No5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int T = scanner.nextInt();
        int[] t = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] p = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] s = new int[k];
        int ans = 0;
        for (int i = 1; i < n; i++) {

            if(p[i]==0){
                ans+=T;
                for (int j = 0; j < k; j++) {
                    if(s[j]>0){
                        s[j]--;
                        ans+=t[p[i]-1];
                        ans-=T;
                        break;
                    }
                }
            }else {
                s[p[i]-1]++;
            }

        }
        System.out.println(ans);
    }
}
