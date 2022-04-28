package com.qx.day21.leetcode;

/**
 * @author Xuan
 * Date: 2021/12/22
 * Time: 10:55
 */
public class No686 {
    public static void main(String[] args) {
        String a = "aba", b = "babbbbaabbababbaaaaababbaaabbbbaaabbbababbbbabaabababaabaaabbbabababbbabababaababaaaaabbabaaaabaaaab";
        System.out.println(repeatedStringMatch(a,b));
    }
    public static int repeatedStringMatch(String a, String b) {
        if(!b.contains(a)){
            if(a.contains(b)){
                return 1;
            }else {
                if((a+a).contains(b)){
                    return 2;
                }else {
                    return -1;
                }
            }
        }else {
            int index = b.indexOf(a);
            int c = index;
            if(a.length()<=index){
                return -1;
            }
            if(!a.substring(a.length()-index).equals(b.substring(0,index))){
                return -1;
            }else {
                int lenA = a.length();
                int lenB = b.length();
                index = lenA-index;

                for (int i = 0; i < b.length(); i++) {
                    if(b.charAt(i)==a.charAt(index%lenA)){
                        index++;
                        continue;
                    }
                    return -1;
                }
                if(c==0){
                    return lenB%lenA==0?lenB/lenA:lenB/lenA+1;
                }
                return (lenB-c)%lenA==0?(lenB-c)/lenA+1:(lenB-c)/lenA+2;
            }
        }
    }
}
