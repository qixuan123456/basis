package Test;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(s);
        String[] sss =  s.split(" ");
        int a = Integer.parseInt(sss[0]);
        int b = Integer.parseInt(sss[1]);
        String ss = scanner.nextLine();
        System.out.println(a+"   "+b);
        System.out.println(ss);
    }
}
