package com.qx.shuati.leetcode;

/**
 * @author xuan
 * @date 2022/5/25 20:42
 */
public class No467 {

    public static void main(String[] args) {
        System.out.println(new No467().findSubstringInWraproundString("zab"));
    }

    public int findSubstringInWraproundString(String p) {
        int[] max = new int[26];
        for(int i=0;i<p.length();i++){
            int len = 1;
            int count = i;
            while(count+1<p.length()&&(p.charAt(count+1)==p.charAt(count)+1||(p.charAt(count)=='z'&&p.charAt(count+1)=='a'))){
                len++;
                count++;
            }
            for (int j = i; j <= count; j++) {
                max[p.charAt(j) - 'a'] = Math.max(max[p.charAt(j)-'a'],count-j+1);
            }
            i = count;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans+=max[i];
        }
        return ans;
    }
}
