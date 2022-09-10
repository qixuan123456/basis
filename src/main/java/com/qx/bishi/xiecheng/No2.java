package com.qx.bishi.xiecheng;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/30 19:02
 */
public class No2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < N; i++) {
            int y = scanner.nextInt();
            int o = scanner.nextInt();
            int u = scanner.nextInt();
            int ans = 0;
            int min = Math.min(y,Math.min(o,u));
            ans+=2*min;
            if(min<o){
                ans+=(o-min-1);
            }
            System.out.println(ans);
        }
    }
}
