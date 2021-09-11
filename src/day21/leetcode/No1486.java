package day21.leetcode;

public class No1486 {
    public static void main(String[] args) {
        int n=10,start=5;
        System.out.println(xorOperation(n,start));
    }
    public static int xorOperation(int n, int start) {
        int num=start;
        for (int i = 1; i < n; i++) {
            num ^=start+2*i;
        }
        return num;
    }
}
