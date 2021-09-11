package day21.leetcode;

public class No1816 {
    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        int k = 4;
        System.out.println(truncateSentence(s,k));
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
}
