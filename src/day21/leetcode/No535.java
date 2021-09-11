package day21.leetcode;

public class No535 {
    public static void main(String[] args) {
        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        System.out.println(decode(encode(longUrl)));
    }
    public static String encode(String longUrl) {
        char[] url = longUrl.toCharArray();
        for (int i = 0; i <url.length; i++) {
            url[i] = (char)(url[i]+1);
        }
        return new String(url);
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        char[] url = shortUrl.toCharArray();
        for (int i = 0; i <url.length; i++) {
            url[i] = (char)(url[i]-1);
        }
        return new String(url);
    }
}
