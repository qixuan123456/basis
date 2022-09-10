package com.qx.help.qianggang;

/**
 * @author xuan
 * @date 2022/9/6 16:38
 */
public class No3 {

    public static void main(String[] args) {
        System.out.println(solution(10,2,1,5,2,5));
    }
    public static int solution(int m,int t1,int m1,int t2,int m2,int t){
        int ans = 0;
        boolean flag1 = false,flag2 = false;
        for (int i = 0; i < t; i++) {
            int temp = 0;
            if(t%t1==0){
                flag1 = !flag1;
            }
            if(t%t2==0){
                flag2 = !flag2;
            }
            if(flag1){
                temp+=m1;
            }

            if(flag2){
                temp-=m2;
            }
            ans = Math.max(0,Math.min(ans+temp,m));
        }
        return ans;
    }
}
