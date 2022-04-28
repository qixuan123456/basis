package com.qx.day04;

public class test03 {


    public static void main(String[] args) {
        String s = "qwerty";
        char[] c = {'a','b','c','d','v',};
        StringBuffer sb = new StringBuffer();

                sb = sb.append(s.charAt(1));
        System.out.println(sb);
       s =  sb.toString();
       char[] ch = s.toCharArray();

        System.out.println("-----------------------------------");
        int a=0;int n=22;
        int max=0;
        boolean flag = false;
        while(n==0)
        {
            if((n&1)==1)
            {
                a=0;
                flag = true;
            }
            else
            {
                if(flag) {
                    a++;
                }
            }

            if(max<a) {
                max=a;
            }
            n = n>>1;
        }
        System.out.println(max);
    }


}
