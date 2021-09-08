package Day21.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class No3 {
    public static void main(String[] args) {
        Solution3 str=new Solution3();
        String s="jbpnbwwd";
       int i = str.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
class Solution3 {
    public Solution3(){

    }
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int num = 0;
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if(set.add(s.charAt(i))){
                num++;
            }
            else{
                while(!set.add(s.charAt(i))){
                    set.remove(s.charAt(count));
                    count++;
                }
                num = set.size();
            }
            if(num>max){
                max = num;
            }
        }
        return max;
    }
}