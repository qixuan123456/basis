package day21.jingsai.no218;


import java.math.BigInteger;

public class No3 {
    public static void main(String[] args) {
        System.out.println(concatenatedBinary(42));
    }
    public static int concatenatedBinary(int n) {
        StringBuilder s = new StringBuilder();
        for(int i = 1;i <= n;i++){
            s.append(Integer.toBinaryString(i));
        }
        BigInteger b = new BigInteger(s.toString(),2);
        return b.mod(new BigInteger(String.valueOf(1000000007))).intValue();
    }
}
