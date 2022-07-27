package com.qx.shuati.tencent.music.shixi2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuan
 * @date 2022/6/17 15:03
 */
public class No6 {

    public int howMany (String S, int k) {
        // write code here
        int ans = 0;
        int[] nums = new int[26];
        for (int i = 0; i < S.length(); i++) {
            nums[S.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(nums[i]>=k){
                ans++;
            }
        }
        return ans;
    }
}
