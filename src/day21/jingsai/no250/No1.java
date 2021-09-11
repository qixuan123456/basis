package day21.jingsai.no250;

public class No1 {

    public static void main(String[] args) {
        String text = "leet code";
        String brokenLetters = "21";
        System.out.println(canBeTypedWords(text,brokenLetters));
    }
    public static int canBeTypedWords(String text, String brokenLetters) {
        int num = 0;
        String[] ss = text.split(" ");
        for (int i = 0; i < ss.length; i++) {
            if(!compare(ss[i],brokenLetters)){
                num++;
            }

        }
        return num;
    }
    public static boolean compare(String s,String c){
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < c.length(); j++) {
                if(s.charAt(i)==c.charAt(j))
                    return true;
            }
        }
        return false;
    }
}
