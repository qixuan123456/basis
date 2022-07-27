package com.qx.shuati.Shopee.be_2022;

/**
 * @author xuan
 * @date 2022/7/19 19:36
 */
public class No1 {

    public static void main(String[] args) {
        GetEndPoint("2A3W");
    }
    public static int[] GetEndPoint (String order) {
        // write code here
        int[] ans = new int[2];
        int i = 0;
        int n = order.length();
        long x=0,y=0;
        while(i<n){
            int a = 0;
            char c;
            while(Character.isDigit(order.charAt(i))){
                a = a*10+(order.charAt(i)-'0');
                i++;
            }
            c = order.charAt(i);
            c = Character.toUpperCase(c);
            if(a==0){
                a=1;
            }
            switch (c){
                case 'W':y+=a;break;
                case 'S':y-=a;break;
                case 'A':x-=a;break;
                case 'D':x+=a;break;
            }
            i++;
        }

        return new int[]{(int)x,(int)y};
    }
}
