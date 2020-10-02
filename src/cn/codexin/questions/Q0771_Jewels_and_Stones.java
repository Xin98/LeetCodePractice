package cn.codexin.questions;

/**
 * Created by xinGao 2020/10/2
 */

public class Q0771_Jewels_and_Stones {
    public int numJewelsInStones(String J, String S) {
        boolean[] jewels = new boolean[58];
        for(int i = 0; i < J.length(); i++) {
            jewels[J.charAt(i) - 'A'] = true;
        }
        int cnt = 0;
        for(int i = 0; i < S.length(); i++) {
            if(jewels[S.charAt(i) - 'A']) {
                cnt++;
            }
        }
        return cnt;
    }
}
