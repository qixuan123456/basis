package com.qx.bishi.dajiang;

import com.qx.test.Tree;

import java.util.List;
import java.util.TreeSet;

/**
 * @author xuan
 * @date 2022/8/7 18:37
 */
public class No1 {

    public int get(List<String> time) {
        int n = time.size();
        if (n > 1440) {
            return 0;
        }
        int[] temp = new int[1440 * 2 + 10];
        for (String s : time) {
            String[] ss = s.split(":");
            int h = Integer.parseInt(ss[0]);
            int m = Integer.parseInt(ss[1]);
            temp[h * 60 + m]++;
            temp[h * 60 + m + 1440]++;
        }
        int ans = 1440, last = -1;
        for (int i = 0; i <= 1440 * 2 && ans != 0; i++) {
            if (temp[i] == 0) {
                continue;
            }
            if (temp[i] > 1) {
                ans = 0;
            } else if (last != -1) {
                ans = Math.min(ans, i - last);
            }
            last = i;
        }
        return ans;
    }

    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            if(num%2==0){
                set.add(num);
            }else {
                set.add(num*2);
            }
        }
        int res = set.last() - set.first();
        while (res > 0 && set.last() % 2 == 0) {
            int max = set.last();
            set.remove(max);
            set.add(max / 2);
            res = Math.min(res, set.last() - set.first());
        }
        return res;
    }
}
