package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/6
 */

public class Q0072_Edit_Distance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 0; i <= len1; i++){
            for(int j = 0; j <= len2; j++){
                if(i == 0) {
                    dp[i][j] = j;
                    continue;
                }
                if(j == 0) {
                    dp[i][j] = i;
                    continue;
                }
                char w1 = word1.charAt(i-1), w2 = word2.charAt(j-1);
                //如果两个子字符串的最后一个字符相等，那么编辑距离和去掉这两个相等的字符的字串相等
                //如果不等，就取删除（任意去掉一个子字符串的最后一个字符）（添加和删除本质上一样）字符或者替换最后一个字符操作的最小值，然后加一（本次操作）。
                dp[i][j] = w1 == w2? dp[i-1][j-1] : (Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1);
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Q0072_Edit_Distance q0072_edit_distance = new Q0072_Edit_Distance();
        q0072_edit_distance.minDistance("horse", "ros");
    }
}
