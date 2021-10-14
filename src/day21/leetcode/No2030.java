package day21.leetcode;

/**
 * User: xuan
 * Date: 2021/10/8
 * Time: 16:30
 */
    //超时
public class No2030 {
    public String res = null;
    public static void main(String[] args) {
        No2030 no2030 = new No2030();
        String s = "leetcode";
        int k = 4;
        char letter = 'e';
        int repetition = 2;
        System.out.println(no2030.smallestSubsequence(s,k,letter,repetition));
    }

    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        qwe(s,k,letter,repetition,0,new StringBuilder());
        return res;
    }

    public void qwe(String s,int k,char letter,int repetition,int count,StringBuilder stringBuilder){
        if(stringBuilder.length()==k){

            if(repetition<=0){
                if(res==null){
                    res=stringBuilder.toString();
                }else {
                    res = res.compareTo(stringBuilder.toString())<1?res:stringBuilder.toString();
                }
            }
            return;
        }

        if(count>=s.length()){
            return;
        }
        if(s.charAt(count)==letter){
            repetition--;
        }
        stringBuilder.append(s.charAt(count));
        qwe(s,k,letter,repetition,count+1,stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        if(s.charAt(count)==letter){
            repetition++;
        }
        qwe(s,k,letter,repetition,count+1,stringBuilder);
    }
}
