package cn.codexin.questions;

/**
 * Created by xinGao 2020/7/8
 */

public class QInterview1611_Diving_Board {
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k == 0) {
            return new int[0];
        }
        int dis = longer - shorter;
        if(dis == 0) {
            return new int[]{shorter * k};
        }
        int[] ans = new int[k + 1];
        ans[0] = shorter * k;
        for (int i = 1; i <= k; i++) {
            ans[i] = ans[i-1] + dis;
        }
        return ans;
    }
}
