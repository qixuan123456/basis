package day21.leetcode;

public class No1816 {
    public static void main(String[] args) {
        String s = "Hello how are you";
        int k = 5;
        System.out.println(truncateSentence1(s,k));
    }
    public static String truncateSentence(String s, int k) {
        String[] ss = s.split(" ");
        String  sss= "";
        for(int i =0;i<k;i++){
            if(i!=0){
                sss+=" ";
            }
            sss+=ss[i];
        }
        return sss;
    }
    //更快的方法
    public static String truncateSentence1(String s, int k) {
        int length = s.length();
        int i=0;
        while(k>0&&i<length){
            if(s.charAt(i)==' '){
                k--;
            }
            i++;
        }
        return i<length?s.substring(0,i-1):s;
    }
}
