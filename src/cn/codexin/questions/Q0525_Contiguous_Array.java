package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2021/6/3
 */

public class Q0525_Contiguous_Array {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> pos = new HashMap<>();
        int counter = 0;
        pos.put(0, -1);
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] == 1) {
                counter++;
            } else {
                counter--;
            }
            if(!pos.containsKey(counter)) {
                pos.put(counter, i);
            } else {
                ans = Math.max(ans, i - pos.get(counter));
            }

        }
        return ans;
    }
}
