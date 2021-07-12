package Day21.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class No3 {
    public static void main(String[] args) {
        Solution3 str=new Solution3();
        String s="abcabcbb";
       int i = str.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int length=0;
        int flag=0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
                length=i-flag+1;
            }
            else{
                int a=map.get(s.charAt(i));
                if(flag>a)
                    length=i-flag;
                else{
                    length=i-a;
                    map.put(s.charAt(i),i);

                }
                flag=a+1;

            }

            if(length>max)
                max=length;
        }
        return max;
    }
}