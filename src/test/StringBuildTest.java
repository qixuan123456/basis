package test;

/**
 * User: xuan
 * Date: 2021/9/25
 * Time: 14:15
 */
public class StringBuildTest {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("123456");
        s.delete(s.length()-1,s.length());
        System.out.println(s);
    }
}
