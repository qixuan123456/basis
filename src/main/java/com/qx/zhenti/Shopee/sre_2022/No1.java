package com.qx.zhenti.Shopee.sre_2022;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuan
 * @date 2022/7/19 14:50
 */
public class No1 {

    public static void main(String[] args) {
        System.out.println(char_and_num_return("aa 12 3 bb "));
    }
    public static String char_and_num_return (String text_source) {
        // write code here
        String[] strings = text_source.split("\\s+");
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if(strings[i].isEmpty()||strings[i].length()==0){
                continue;
            }
            if(Character.isDigit(strings[i].charAt(0))){
                list.add(strings[i]);
            }else {
                if(sb.length()!=0){
                    sb.append(" ");
                }
                sb.append(strings[i]);
            }
        }
        list.sort((a,b)->{
            if(a.length()!=b.length()){
                return a.length()-b.length();
            }else {
                return a.compareTo(b);
            }
        });
        for (int i = 0; i < list.size(); i++) {
            if(sb.length()!=0){
                sb.append(" ");
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }



}
