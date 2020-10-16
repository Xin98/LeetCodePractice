package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2020/10/16
 */

public class Q0219_Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numsIndexMap = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(numsIndexMap.containsKey(nums[i]) && i - numsIndexMap.get(nums[i]) <= k) {
                return true;
            } else {
                numsIndexMap.put(nums[i], i);
            }
        }
        return false;
    }
}
