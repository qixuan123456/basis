package day21.leetcode;

public class No50 {
    public static void main(String[] args) {
        double x=5;
        int n=-1;
        System.out.println(myPow(x,n));
    }
    public static double myPow(double x, int n) {
        return Math.pow(x,(double) n);
    }
}
