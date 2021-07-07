package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2021/7/7
 */

public class Q1711_Count_Good_Meals {
    public int countPairs(int[] deliciousness) {
        int mod = (int)1e9 + 7;
        int maxVal = 0;
        for (int food : deliciousness) {
            maxVal = Math.max(maxVal, food);
        }
        int maxSum = 2 * maxVal;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int food : deliciousness) {
            for (int i = 1; i <= maxSum; i<<=1) {
                int count = map.getOrDefault(i - food, 0);
                ans = (ans + count) % mod;
            }
            map.put(food, map.getOrDefault(food, 0) + 1);
        }
        return ans;
    }
}
