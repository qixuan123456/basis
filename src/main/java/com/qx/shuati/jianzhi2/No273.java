package com.qx.shuati.jianzhi2;

/**
 * @author xuan
 * @date 2022/4/20 15:44
 */
public class No273 {
    public static void main(String[] args) {
        System.out.println(numberToWords(111));
    }
    //1 234 567 891
    //One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One

    public static String numberToWords(int num) {

        String[] ge = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"," Ten",
                " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
        String[] bai = {""," Ten"," Twenty"," Thirty"," Forty"," Fifty"," Sixty"," Seventy"," Eighty"," Ninety"};
        String[] danwei = {""," Thousand"," Million"," Billion"};
        String hundred = " Hundred";
        String sn = String.valueOf(num);
        int len = sn.length();
        String[] ss = new String[(sn.length()+2)/3];
        for (int i = 0; i < ss.length; i++) {
            if(i==ss.length-1){
                ss[i] = sn.substring(0,len-3*i);
            }else {
                ss[i] = sn.substring(len - 3 * (i + 1), len - 3 * i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length-1; i >= 0; i--) {
            if(Integer.parseInt(ss[i])==0){
                continue;
            }
            int l = ss[i].length();
            String b;

            if(l>2){
                b = ge[ss[i].charAt(l-3)-'0'];
                if(b!=""){
                    sb.append(b).append(hundred);
                }
            }

            if(l>1){
                int count = Integer.parseInt(ss[i].substring(l-2,l));
                if(count>=20){
                    b = bai[ss[i].charAt(l-2)-'0'];
                    sb.append(b);
                    sb.append(ge[ss[i].charAt(l-1)-'0']);
                }else{
                    b = ge[count];
                    sb.append(b);
                }
            }
            if(l==1){
                sb.append(ge[ss[i].charAt(0)-'0']);
            }
            sb.append(danwei[i]);
        }
        return sb.toString().trim();
    }
}
