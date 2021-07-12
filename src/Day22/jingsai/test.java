package Day22.jingsai;

import java.util.HashSet;
import java.util.Set;

public class test {
    public static void main(String[] args) {

        //System.out.println(leastMinutes(1));//第一题
        int[] questions = {1,5,1,3,4,5,2,5,3,3,8,6};
        System.out.println(halfQuestions(questions));//第二题
    }
    public static int leastMinutes(int n) {
        int i=0;
        int a=1;
        while (n>a){
            a=a*2;
            i++;
        }
        return i+1;
    }
    public static int halfQuestions(int[] questions) {
        Set<Integer> s = new HashSet<>();
        for (int i=0;i<questions.length;i++){
            s.add(questions[i]);
        }
        return s.size()/(questions.length/2);
    }
}
