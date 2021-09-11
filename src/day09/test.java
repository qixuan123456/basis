package day09;

import java.math.BigInteger;

public class test {
public byte[] id = {1,0};

    public static void main(String[] args) {
        System.out.println(new test().nextBit("1"));

        String s = "qwer";
        System.out.println(s.hashCode());
    }

    public byte nextBit(String startPattern) {

        if (this.toBinaryString().startsWith(startPattern + "1")) {
            return 1;
        } else {
            return 0;
        }
    }
    public String toBinaryString() {

        BigInteger bi = new BigInteger(1, id);
        String out = String.format("%512s", bi.toString(2));
        out = out.replace(' ', '0');

        return out;
    }
}
