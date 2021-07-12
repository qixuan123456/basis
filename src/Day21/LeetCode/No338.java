package Day21.LeetCode;

import Day21.tool.Util;

public class No338 {
    public static void main(String[] args) {
        int[] c = countBits(8);
        Util.printArray(c);
    }
    public static int[] countBits(int n) {
        int[] c = new int[n+1];
        int a = 1;
        for (int i = 0; i <= n; i++) {
            if(i==0) c[i] = 0;
            else if(i==1) c[i] = 1;
            else{
                c[i] =c[i%a]+1;
            }
        if(a*2==i)
            a=a*2;
        }
        return c;
    }
}
