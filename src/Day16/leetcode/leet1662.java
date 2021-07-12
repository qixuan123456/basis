package Day16.leetcode;

public class leet1662 {

    public static void main(String[] args) {
        StringBuffer a = new StringBuffer();
        StringBuffer b = new StringBuffer();
        a.append("abcd");
        a.append("efg");
        b.append("abcdefg");
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(a.toString().equals(b.toString()));
        char c='a';
        char d = (char)(c+5);
        System.out.println(d);
    }
}
