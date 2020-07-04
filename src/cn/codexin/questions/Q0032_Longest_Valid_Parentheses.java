package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/4
 */

public class Q0032_Longest_Valid_Parentheses {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if(s.charAt(i) == ')') {
                if(s.charAt(i-1) == '(') {
                    dp[i] = i > 2 ? dp[i - 2] + 2 : 2;
                } else if(i > dp[i - 1] && s.charAt(i - 1 - dp[i - 1]) == '('){
                    dp[i] = dp[i - 1] + 2 + ((i - dp[i-1] >= 2) ? dp[i - dp[i-1] -2] :0);
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q0032_Longest_Valid_Parentheses Q = new Q0032_Longest_Valid_Parentheses();
        Q.longestValidParentheses(")()())");
    }
}
