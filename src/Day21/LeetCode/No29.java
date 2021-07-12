package Day21.LeetCode;

public class No29 {
    public static void main(String[] args) {

        int dividend = -2147483648;
        int divisor = -1;
        System.out.println(divide(dividend,divisor));
    }
    public static int divide(int dividend, int divisor) {
        int i=0;
        boolean flag1 = false;
        boolean flag2 = false;
        if(dividend==-2147483648&&divisor==-1){
            return 2147483647;
        }
        if(dividend<0){
            flag1 = true;
            dividend = -dividend;
        }
        if(divisor<0){
            flag2 = true;
            divisor = -divisor;
        }
        while(dividend>=divisor){
            if(i+1>i){
                i=i+1;
                dividend = dividend-divisor;
            }else{
                return 2147483647;
            }

        }
        if(flag1){
            i=-i;
        }
        if(flag2){
            i=-i;
        }
        return i;
    }
}
