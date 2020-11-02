package cn.codexin.questions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by xinGao 2020/11/2
 */

public class Q0349_Intersection_of_Two_Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n) {
            return intersection(nums2, nums1);
        }
        if(m == 0) {
            return new int[]{};
        }
        List<Integer> ans = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for(int num : nums1) {
            set.add(num);
        }
        for(int num : nums2) {
            if(set.contains(num)) {
                ans.add(num);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
