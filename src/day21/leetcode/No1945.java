package day21.leetcode;

public class No1945 {
    public static void main(String[] args) {
        String s = "zbax";
        int k = 2;
        System.out.println(getLucky(s,k));
    }
    public static int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)-'a'+1);
        }
        s=sb.toString();
        for (int i = 0; i < k; i++) {
            s = getLucky(s);
        }
        return Integer.parseInt(s);
    }
    public static String getLucky(String s){
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            c += s.charAt(i)-'0';
        }
        return Integer.toString(c);
    }
}
