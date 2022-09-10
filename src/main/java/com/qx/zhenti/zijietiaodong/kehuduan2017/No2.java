package com.qx.zhenti.zijietiaodong.kehuduan2017;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/9/4 15:38
 */
public class No2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int l = scanner.nextInt();

        if(((l+1)/(m+1))%13!=0){
            System.out.println((n+(l+1)/(m+1)-1)/((l+1)/(m+1)));
        }else{
            System.out.println((n+(l+1)/(m+1)-2)/((l+1)/(m+1)-1));
        }
    }
}
