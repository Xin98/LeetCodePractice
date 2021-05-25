package cn.codexin.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2021/5/25
 */

public class Q1787_Make_the_XOR_of_All_Segments_Equal_to_Zero {
    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        int MAXX = 1 << 10;
        int INF = Integer.MAX_VALUE / 2;
        int[] f = new int[MAXX];
        Arrays.fill(f, INF);
        // f(-1, 0) = 0
        f[0] = 0;
        for (int i = 0; i < k; i++) {
            int t2 = Arrays.stream(f).min().getAsInt();
            int[] g = new int[MAXX];
            Arrays.fill(g, t2);
            Map<Integer, Integer> cnt = new HashMap<>();
            int size = 0;
            for (int j = i; j < n; j+=k) {
                cnt.put(nums[j], cnt.getOrDefault(nums[j], 0) + 1);
                size++;
            }
            for (int mask = 0; mask < MAXX; mask++) {
                for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                    int x = entry.getKey();
                    int cntX = entry.getValue();
                    g[mask] = Math.min(g[mask], f[mask ^ x] - cntX);
                }
                g[mask] += size;
            }
            f = g;
        }
        return f[0];
    }
}
