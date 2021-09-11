package day21.leetcode;

import java.util.HashMap;

public class No242 {

    public static void main(String[] args) {
        String s = "12312";
        String t = "532121";
        System.out.println(isAnagram(s,t));
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        HashMap<Character,Integer> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(sMap.getOrDefault(s.charAt(i),0)!=0){
                sMap.put(s.charAt(i),sMap.get(s.charAt(i))+1);
            }
            else
            sMap.put(s.charAt(i),1);
        }
        for (int i = 0; i < t.length(); i++) {
            if(sMap.getOrDefault(t.charAt(i),0)<1){
                return false;
            }
            else {
                sMap.put(t.charAt(i),sMap.get(t.charAt(i))-1);
            }
        }
        return true;
    }
}
