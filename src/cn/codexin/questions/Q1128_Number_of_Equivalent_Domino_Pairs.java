package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2021/1/26
 */

public class Q1128_Number_of_Equivalent_Domino_Pairs {
    public int getId(int a, int b) {
        return 10 * Math.min(a, b) + Math.max(a, b);
    }
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> pairCnt = new HashMap<>();
        int ans = 0;
        for (int[] dominoe : dominoes) {
            int pairId = getId(dominoe[0], dominoe[1]);
            pairCnt.put(pairId, pairCnt.getOrDefault(pairId, 0) + 1);
            ans += pairCnt.get(pairId);
        }
        return ans;
    }
}
