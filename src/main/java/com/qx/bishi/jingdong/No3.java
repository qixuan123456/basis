package com.qx.bishi.jingdong;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/27 20:07
 */
public class No3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n / 3; i++) {
            stringBuilder.append("red");
        }
        if(n%3==1){
            stringBuilder.append("r");
        }
        if(n%3==2){
            stringBuilder.append("re");
        }
        char[] chars = stringBuilder.toString().toCharArray();
        long ans = 0;
        int mod = 1000000007;
        long l = 0,r =0;
        int first = -1;
        int second = -1;
        for (int i = 0; i < n-2; i++) {
            if(chars[i]=='r'&&chars[i+1]=='e'&&chars[i+2]=='d'){
                if(first==-1){
                    first = i;
                    continue;
                }
                if(second==-1){
                    second = i;
                }
                r = i+2;
            }
            if(first!=-1&&second!=-1){
                ans= (ans+ ( (n - r) *(first-l+1))%mod)%mod;
                l = i;
                first = second;
                second = -1;
            }
        }

        System.out.println(ans);
    }
}
