package cn.codexin.questions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by xinGao 2020/7/13
 */

public class Q0350_Intersection_of_Two_Arrays_II {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        int max = nums1.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> ans = new LinkedList<>();
        for (int num : nums2) {
            if(max == 0) {
                break;
            }
            int value = map.getOrDefault(num, 0);
            if(value > 0) {
                map.put(num, value-1);
                ans.add(num);
                max--;
            }
        }
        return ans.stream().mapToInt(x -> x).toArray();
    }
}
