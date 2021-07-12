package Day21.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No1748 {
    public static void main(String[] args) {
        int arg[]= {1,2,3,4,4};
       

        Map<Integer,Integer> a = new HashMap<>();
        int num = 0;
        for (int i = 0; i < arg.length; i++) {
            if(a.getOrDefault(arg[i],0)==0){
                a.put(arg[i],1);
            }
            else
                a.put(arg[i],a.getOrDefault(arg[i],0)+1);
        }
        for (Integer i :
                a.keySet()) {
            if(a.get(i)==1){
                num+=i;
            }
        }
        System.out.println(num);
    }


}
