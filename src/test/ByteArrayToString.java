package test;

public class ByteArrayToString {
    public static void main(String[] args) {
        String s = "123456789";
        byte[] b = s.getBytes();
        for (byte a:b){
            System.out.print(a+"\t");
        }
        System.out.println();
        System.out.println(new String(b));

    }
}
