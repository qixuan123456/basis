package day16.leetcode;

public class leet1009 {
    public static void main(String[] args) {
        String s = Integer.toBinaryString(5);
        System.out.println(s);
        int a=0;
        char[] c = s.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]=='1'){
                a=a*2+(int)(c[i]-'0')-1;
                System.out.println(a);
            }
            else {
                a=a*2+(int)(c[i]-'0')+1;
                System.out.println(a);
            }
        }
        System.out.println(a);
    }
}
