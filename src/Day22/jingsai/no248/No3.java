package Day22.jingsai.no248;

public class No3 {
    public static void main(String[] args) {
        long n = 50L;
        System.out.println(countGoodNumbers(n));
    }
    public static int countGoodNumbers(long n) {
        long ans = 1;
        while(n>0){
            if((n&1)==1){
                ans *=5;
            }
            else{
                ans *=4;
            }
            n--;
            if(ans>=1000000007){
                ans = ans%1000000007;
            }
        }
        return (int)ans;
    }
}
