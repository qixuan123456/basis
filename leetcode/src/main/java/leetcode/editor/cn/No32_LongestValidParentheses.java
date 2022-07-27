//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 👍 1893 👎 0

package leetcode.editor.cn;

/**
  * 题目Id：32; 
  * 题目：最长有效括号，longest-valid-parentheses; 
  * 日期：2022-07-06 18:48:47
*/

public class No32_LongestValidParentheses{
    public static void main(String[] args) {
        Solution solution = new No32_LongestValidParentheses().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if(s.charAt(i-1)==')'){
                if(i-2>=0&&s.charAt(i-2)=='('){
                    dp[i] = dp[i-2]+2;
                }else {
                    if(i-2-dp[i-1]>=0&&s.charAt(i-2-dp[i-1])=='('){
                        dp[i] = dp[i-1]+2+dp[i-2-dp[i-1]];
                    }
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}