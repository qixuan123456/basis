package com.qx.shuati.leetcode;

/**
 * @author xuan
 * @date 2022/5/9 16:47
 */
public class No839 {
    public static void main(String[] args) {
        String[] strs = {"tars","rats","arts","star"};
        System.out.println(new No839().numSimilarGroups(strs));
        int a = Integer.parseInt("1");
    }

    public int numSimilarGroups(String[] strs) {
        if(strs.length<2){
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = i+1; j < strs.length; j++) {
                if(check(strs[i],strs[j])){
                    ans++;
                }
            }
        }
        return ans;
    }

    public boolean check(String s1,String s2){
        int res = 0;
        int r = 0;
        if(s1.length()!=s2.length()){
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i)!=s2.charAt(i)){
                r++;
                if(r>2){
                    return false;
                }
            }
            res = res^s1.charAt(i)^s2.charAt(i);
        }
        return res==0&&(r==0||r==2);
    }

}
