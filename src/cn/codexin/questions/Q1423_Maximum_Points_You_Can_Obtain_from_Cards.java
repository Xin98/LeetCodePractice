package cn.codexin.questions;

/**
 * Created by xinGao 2021/2/6
 */

public class Q1423_Maximum_Points_You_Can_Obtain_from_Cards {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int ans = sum;
        for(int i = 0; i < k; i++) {
            sum += cardPoints[n - i - 1];
            sum -= cardPoints[k - i - 1];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
