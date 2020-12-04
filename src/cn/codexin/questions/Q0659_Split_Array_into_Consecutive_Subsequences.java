package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2020/12/4
 */

public class Q0659_Split_Array_into_Consecutive_Subsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        Map<Integer, Integer> substrMap = new HashMap<>();
        for(int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        for(int num : nums) {
            int cnt = cntMap.get(num);
            if(cnt == 0) {
                continue;
            }
            if(substrMap.getOrDefault(num - 1, 0) > 0) {
                substrMap.put(num - 1, substrMap.get(num - 1) - 1);
                substrMap.put(num, substrMap.getOrDefault(num, 0) + 1);
                cntMap.put(num, cnt - 1);
            } else {
                int cnt1 = cntMap.getOrDefault(num + 1, 0);
                int cnt2 = cntMap.getOrDefault(num + 2, 0);
                if(cnt1 > 0 && cnt2 > 0) {
                    substrMap.put(num + 2, substrMap.getOrDefault(num + 2, 0) + 1);
                    cntMap.put(num, cnt - 1);
                    cntMap.put(num + 1, cnt1 - 1);
                    cntMap.put(num + 2, cnt2 - 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
