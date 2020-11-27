package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2020/11/27
 */

public class Q0454_4Sum_II {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : A) {
            for(int m : B) {
                map.put(-(n + m), map.getOrDefault(-(n + m), 0) + 1);
            }
        }
        int ans = 0;
        for(int n : C) {
            for(int m : D) {
                if(map.containsKey(n + m)) {
                    ans += map.get(n + m);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q0454_4Sum_II Q = new Q0454_4Sum_II();
        Q.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2});
    }
}
