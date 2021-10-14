package day21.leetcode;

/**
 * User: xuan
 * Date: 2021/10/10
 * Time: 16:09
 */
public class No441 {
    public static void main(String[] args) {
        int n = 0;
        No441 no441 = new No441();
        System.out.println(no441.arrangeCoins(n));
    }
    public int arrangeCoins(int n) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if((n = n-(i+1))>=0){
                ans++;
            }else {
                break;
            }
        }
        return ans;
    }
}
