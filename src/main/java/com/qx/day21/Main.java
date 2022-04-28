package com.qx.day21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Xuan
 * Date: 2021/12/18
 * Time: 12:44
 */
public class Main {
    public static void main(String[] args) throws IOException {
        
    }

    public void first() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int line;
        while((line=Integer.parseInt(in.readLine()))!=0){
            System.out.println(sum(line));
        }
    }

    public void second() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Set<Integer> set = new HashSet<>();
        while ((line=in.readLine())!=null){
            int a ;
            int l = Integer.parseInt(line);
            for (int i = 0; i < l; i++) {
                a=Integer.parseInt(in.readLine());
                set.add(a);
            }
            List<Integer> list = new ArrayList<>(set);
            list.sort(Integer::compareTo);
            for (Integer i : list) {
                System.out.println(i);
            }
        }
    }

    public void third() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line=in.readLine())!=null){
            System.out.println(Integer.parseInt(line.substring(2),16));
        }
    }

    public static int sum(int a){
        int res = 0;
        while(a>=3){
            res += a/3;
            a = a/3+a%3;
        }
        if(a==2){
            res++;
        }
        return res;
    }
}
