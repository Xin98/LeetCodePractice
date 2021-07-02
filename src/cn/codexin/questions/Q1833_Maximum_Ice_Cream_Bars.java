package cn.codexin.questions;

/**
 * Created by xinGao 2021/7/2
 */

public class Q1833_Maximum_Ice_Cream_Bars {
    public int maxIceCream(int[] costs, int coins) {
        int n = (int) 1e5;
        int[] freq = new int[n + 1];
        for (int cost : costs) {
            freq[cost]++;
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if(coins >= i) {
                int curCount = Math.min(freq[i], coins / i);
                cnt += curCount;
                coins -= i * curCount;
            } else {
                break;
            }
        }
        return cnt;
    }
}
