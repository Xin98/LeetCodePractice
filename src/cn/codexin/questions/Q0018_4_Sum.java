package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2020/10/8
 */

public class Q0018_4_Sum {
    private List<List<Integer>> ans;
    private int n;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        n = nums.length;
        ans = new LinkedList<>();
        for(int i = 0; i < n - 3; i++) {
            if(i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            threeSum(nums, i, target - nums[i]);
        }
        return ans;
    }
    public void threeSum(int[] nums, int leftBound, int target) {
        if(leftBound >= n - 3) {
            return;
        }
        for(int i = leftBound + 1; i < n - 2; i++) {
            if(i != leftBound + 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, leftBound, i, target - nums[i]);
        }
    }
    public void twoSum(int[] nums,int left, int leftBound, int target) {
        if(leftBound >= n - 1) {
            return;
        }
        Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for(int i = leftBound + 1; i < n; i++) {
            if(set.contains(nums[i])) {
                if(resultSet.contains(nums[i])) {
                    continue;
                }
                ans.add(new LinkedList<>(Arrays.asList(nums[left], nums[leftBound], target - nums[i], nums[i])));
                resultSet.add(nums[i]);
            } else {
                set.add(target - nums[i]);
            }
        }
    }
}
