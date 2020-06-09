package cn.codexin.questions;

/**
 * Created by xinGao 2020/6/9
 */

public class QInterview0046_Num_to_String {
    public int translateNum(int num) {
        char[] numChars = String.valueOf(num).toCharArray();
        int n = numChars.length;
        if(n < 2) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = (numChars[0] == '1' || (numChars[0] == '2' && numChars[1] <= '5')) ? 2 : 1;
        for(int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + (numChars[i-1] == '1' || (numChars[i-1] == '2' && numChars[i] <= '5') ? dp[i-2] : 0);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        QInterview0046_Num_to_String Q = new QInterview0046_Num_to_String();
        Q.translateNum(
                987414569);
    }
}
