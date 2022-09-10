package com.qx.shuati.jianzhi2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xuan
 * @date 2022/8/20 10:24
 */
public class No5 {

    public int maxProduct(String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < words[i].length(); j++) {
                set.add(words[i].charAt(j));
            }

            for (int j = i+1; j < words.length; j++) {
                boolean flag = true;
                for (int k = 0; k < words[j].length(); k++) {
                    if(set.contains(words[j].charAt(k))){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    ans = Math.max(ans,words[i].length()*words[j].length());
                }
            }
        }
        return ans;
    }
}
