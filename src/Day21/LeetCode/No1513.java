package Day21.LeetCode;

import java.util.Scanner;

/**
 * @author xuan
 */
public class No1513 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(numSub(s));
    }

    public static int numSub(String ss) {
        long len = 0;
        long res = 0;
        for (int i = 0; i < ss.length(); i++) {
            if (ss.charAt(i) == '1') {
                len++;
            } else {
                res += ((len + 1) * len / 2)%1000000007;
                res %=1000000007;
                len = 0;
            }
        }
        res += ((len + 1) * len / 2)%1000000007;
        return (int)(res%1000000007);
    }
}
