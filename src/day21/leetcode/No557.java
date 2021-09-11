package day21.leetcode;

public class No557 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        StringBuilder s1 = new StringBuilder();
        String[] ss = s.split(" ");
        for (String value : ss) {
            StringBuilder s2 = new StringBuilder(value);
            s1.append(s2.reverse().toString()).append(" ");
        }
        s1.deleteCharAt(s1.length()-1);
        return s1.toString();
    }
}
