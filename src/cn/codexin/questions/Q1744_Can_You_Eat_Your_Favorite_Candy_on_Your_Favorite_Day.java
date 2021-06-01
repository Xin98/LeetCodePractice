package cn.codexin.questions;

/**
 * Created by xinGao 2021/6/1
 */

public class Q1744_Can_You_Eat_Your_Favorite_Candy_on_Your_Favorite_Day {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = queries.length;
        boolean[] ans = new boolean[n];
        int length = candiesCount.length;
        long[] preSum = new long[length + 1];
        for (int i = 1; i <= length; i++) {
            preSum[i] = preSum[i - 1] + candiesCount[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int[] query = queries[i];
            int type = query[0], day = query[1], cap = query[2];
            long min = preSum[type] + 1;
            long max = preSum[type + 1];
            long left = day + 1;
            long right = (long)(day + 1) * cap;
            if(!(min > right || max < left)) {
                ans[i] = true;
            }
        }
        return ans;
    }
}
