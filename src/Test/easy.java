package Test;

import java.util.Scanner;

public class easy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = "abcdesAssayEaaaassYyy";
        s=scanner.nextLine();
        int res = 0;
        int count = 0;
        char[] target1 = {'e','a','s','y'};
        char[] target2 = {'E','A','S','Y'};
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==target1[count]||s.charAt(i)==target2[count]){
                if(count==3){
                    res++;
                    count = 0;
                }else {
                    count++;
                }
            }
        }
        System.out.println(res);
    }
}
