package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2021/4/17
 */

public class Q0220_Contains_Duplicate_III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Long> map = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; i++) {
            long id = getId(nums[i], w);
            if(map.containsKey(id)) {
                return true;
            }
            if(map.containsKey(id - 1) && Math.abs(map.get(id - 1) - nums[i]) < w) {
                return true;
            }
            if(map.containsKey(id + 1) && Math.abs(map.get(id + 1) - nums[i]) < w) {
                return true;
            }
            map.put(id, (long)nums[i]);
            if(i >= k) {
                map.remove(getId(nums[i - k],w ));
            }
        }
        return false;
    }

    public long getId(long x, long w) {
        if(x >= 0) {
            return x / w;
        }
        return (x + 1) / w - 1;
    }
}
