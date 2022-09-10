package com.qx.zhenti.Shopee.be_2022;

/**
 * @author xuan
 * @date 2022/7/19 19:56
 */
public class No2 {

    public String compressString (String param) {
        // write code here
        StringBuilder sb = new StringBuilder();
        int n = param.length();
        int i = 0;
        while(i<n){
            char c = param.charAt(i);
            int num = 1;
            i++;

            while (i<n&&param.charAt(i)==c){
                num++;
                i++;
            }
            sb.append(c);
            if(num!=1){
                sb.append(num);
            }
        }
        return sb.toString();
    }
}
