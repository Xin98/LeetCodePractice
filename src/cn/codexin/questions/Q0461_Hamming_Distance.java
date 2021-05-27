package cn.codexin.questions;

/**
 * Created by xinGao 2021/5/27
 */

public class Q0461_Hamming_Distance {
    public int hammingDistance(int x, int y) {
        int MAXB = 31;
        int ans = 0;
        for (int i = 0; i < MAXB; i++) {
            if(((x >> i) & 1) != ((y >> i) & 1)) {
                ans++;
            }
        }
        return ans;
    }
}
