package com.qx.bishi.zijie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/9/4 20:08
 */
public class No4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {

            int a = scanner.nextInt();
            int b = scanner.nextInt();
            scanner.nextLine();
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            Map<Character,Integer> map = new HashMap<>();
            int l = 0,r=0;
            int ans = 0;
            map.put(s1.charAt(0),1);
            while(l<=r&&r<a){
                if(map.size()==1){
                    r++;
                    if(r<a&&s2.charAt(r)=='0'){
                        map.put(s1.charAt(r),map.getOrDefault(s1.charAt(r),0)+1);
                    }
                }else {
                    if(s2.charAt(l)=='0'){
                        if(map.get(s1.charAt(l))==1){
                            map.remove(s1.charAt(l));
                        }else {
                            map.put(s1.charAt(l),map.getOrDefault(s1.charAt(l),0)-1);
                        }

                        l++;
                    }else {
                        l++;
                    }
                }
                ans = Math.max(ans,r-l+1);
            }
            System.out.println(Math.min(ans,a));
        }
    }
}
