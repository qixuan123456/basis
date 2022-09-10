package com.qx.shuati.jingsai.no76;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2022/4/21 19:58
 */
public class No3 {
    public static int[] a = {20, 50, 100, 200, 500};
    public static int[] ansDeposit = {0, 0, 0, 0, 0};

    public static void main(String[] args) {
        No3 n = new No3();
        n.deposit(new int[]{0,0,1,2,1});
        System.out.println(Arrays.toString(n.withdraw(600)));
        n.deposit(new int[]{0, 1, 0, 1, 1});
        System.out.println(Arrays.toString(n.withdraw(600)));
        System.out.println(Arrays.toString(n.withdraw(550)));
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) {
            ansDeposit[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] b = new int[]{0, 0, 0, 0, 0};
        for (int i = 4; i >= 0; i--) {
            int m = amount/a[i];
            if(m>=ansDeposit[i]){
                b[i]+=ansDeposit[i];
                amount-=a[i]*ansDeposit[i];
                ansDeposit[i] = 0;
            }else{
                b[i]+=m;
                amount-=a[i]*m;
                ansDeposit[i]-=m;
            }
        }
        if (amount != 0) {
            deposit(b);
            return new int[]{-1};
        }
        return b;
    }

}
