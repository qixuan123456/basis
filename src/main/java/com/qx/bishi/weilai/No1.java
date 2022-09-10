package com.qx.bishi.weilai;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/5 19:37
 */
public class No1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        System.out.println(getAns(s1,s2));
    }

    public static String getAns(String s,String t){
        Map<Character,Integer> tMap = new HashMap<>();
        for(char c: t.toCharArray()){
            if(tMap.containsKey(c)){
                tMap.put(c,tMap.get(c)+1);
            }else {
                tMap.put(c,1);
            }
        }
        for (char c: s.toCharArray()) {
            if(t.indexOf(c)==-1){
                tMap.put(c,0);
            }
        }

        int count = t.length();
        int begin = 0;
        int end = 0;
        int head = 0;
        int tempCount ;
        int distance = Integer.MAX_VALUE;
        while (end<s.length()){
            tempCount = tMap.get(s.charAt(end));
            if(tempCount>0){
                count--;
            }
            tMap.put(s.charAt(end),--tempCount);
            end++;
            while (count==0){
                if(end-begin<distance){
                    distance = end-begin;
                    head = begin;
                }
                tempCount = tMap.get(s.charAt(begin));
                tMap.put(s.charAt(begin),++tempCount);
                if(tempCount>0){
                    count++;
                }
                begin++;


            }



        }
        return distance ==Integer.MAX_VALUE?"":s.substring(head,head+distance);
    }
}
