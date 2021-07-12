package Day21.LeetCode;

public class No38 {
    public static void main(String[] args) {
        int n=4;
        System.out.println(countAndSay(n));

    }
    public static String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String s="1";
        while (n>1){
           s = countAnd(s);
            n--;
        }

        return s;
    }
    public static String countAnd(String s){
        String ss="";
        char c=s.charAt(0);
        int num=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                num++;
            }
            else{
                ss=ss+num+c;
                c=s.charAt(i);
                if(i==s.length()-1){
                    return ss+1+c;
                }
                num=1;
            }
        }
        ss=ss+num+c;
        return ss;
    }
}
