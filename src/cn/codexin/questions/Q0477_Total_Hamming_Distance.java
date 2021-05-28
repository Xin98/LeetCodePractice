package cn.codexin.questions;

/**
 * Created by xinGao 2021/5/28
 */

public class Q0477_Total_Hamming_Distance {
    public int totalHammingDistance(int[] nums) {
        int MAXB = 30;
        int[] bitCnt = new int[30];
        int n = nums.length;
        int ans = 0;
        for (int num : nums) {
            for (int i = 0; i < MAXB; i++) {
                if(((num >> i) & 1) == 1){
                    bitCnt[i]++;
                }
            }
        }
        for (int cnt : bitCnt) {
            ans += cnt * (n - cnt);
        }
        return ans;
    }
}
