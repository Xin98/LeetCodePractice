package cn.codexin.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xinGao 2021/2/20
 */

public class Q0697_Degree_of_an_Array {
    public int findShortestSubArray(int[] nums) {
        // {num, [begin, end, times]}
        Map<Integer, int[]> map = new HashMap<>();
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            int[] info = map.getOrDefault(nums[i], new int[]{i, i, 1});
            info[1] = i;
            info[2]++;
            map.put(nums[i], info);
        }
        int maxTimes = 1, ans = 1;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] info = entry.getValue();
            int len = info[1] - info[0] + 1;
            if(info[2] > maxTimes) {
                maxTimes = info[2];
                ans = len;
            } else if(info[2] == maxTimes) {
                ans = Math.min(ans, len);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        Q0697_Degree_of_an_Array Q = new Q0697_Degree_of_an_Array();
        Q.findShortestSubArray(new int[]{1,2,2,3,1});
    }
}
