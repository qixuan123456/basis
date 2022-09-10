package com.qx.shuati.jingsai.no199;

public class No1 {
    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4,5,6,7,0,2,1,3};
        String s1 = restoreString(s,indices);
        System.out.println(s1);
    }
    public static String restoreString(String s, int[] indices) {
        char[] chars = new char[s.length()];
        for(int i=0;i<indices.length;i++){
            chars[indices[i]] = s.charAt(i);
        }
        return new String(chars);
    }
}
