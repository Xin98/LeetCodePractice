package cn.codexin.questions;

import java.util.HashMap;

/**
 * Created by xinGao 2020/4/11
 */

public class Q0887_Super_Egg_Drop {
    //记忆化
    private HashMap<Integer, Integer> memo = new HashMap<>();
    public int superEggDrop(int K, int N) {

        return dp(K, N);
    }
    //dp + 二分搜索
    //状态转移 dp[k][n] = min x=(0-n)( max(dp[k][n-x], dp[k-1][x-1])  )
    public int dp(int K, int N){
        // 1 < N <= 10000， 1 < K <= 100，因此可以通过此计算给不同的N,K得到唯一的indexed
        int indexed = 100 * N + K, ans;
        if(memo.containsKey(indexed)) return memo.get(indexed);
        if(N == 0)  return ans = 0;
        if(K == 1) return ans = N;
        int l = 1, r = N;
        while(l + 1 < r){
            int x = (l+r)/2;
            int t1 = dp(K, N - x);
            int t2 = dp(K-1, x-1);
            if(t1 > t2) l = x + 1;
            else if(t1 < t2) r = x-1;
            else l = r = x;
        }
        ans = 1 + Math.min(Math.max(dp(K, N - l), dp(K-1, l-1)),
                            Math.max(dp(K, N-r), dp(K-1, r-1)));
        memo.put(indexed, ans);
        return ans;

    }
}
