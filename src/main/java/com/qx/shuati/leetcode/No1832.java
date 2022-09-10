package com.qx.shuati.leetcode;

import java.util.HashSet;
import java.util.Set;

public class No1832 {
    public static void main(String[] args) {
        String sentence = "thequckbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(sentence));
    }
    public static boolean checkIfPangram(String sentence) {
        if(sentence.length()<26){
            return false;
        }
        Set<Character> s = new HashSet<>();
        for(int i=0;i<sentence.length();i++){
            s.add(sentence.charAt(i));
        }
        if(s.size()==26){
            return true;
        }
        return false;
    }
}
