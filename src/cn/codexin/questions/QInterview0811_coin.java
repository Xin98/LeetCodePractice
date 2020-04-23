package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/23
 */

public class QInterview0811_coin {
    private int mod = 1000000007;
    public int waysToChange(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        int[] coins = new int[]{25, 10, 5, 1};
        for(int i = 0; i < 4; i++){
            int coin = coins[i];
            for(int j = coin; j <= n; j++){
                dp[j] = (dp[j] + dp[j-coin]) % mod;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        QInterview0811_coin qInterview0811_coin = new QInterview0811_coin();
        qInterview0811_coin.waysToChange(10);
    }
}
