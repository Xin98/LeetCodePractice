package cn.codexin.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/6/12
 */

public class Q0015_3_Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new LinkedList<>();
        if(n < 3 || (long)nums[0] * nums[n-1] > 0) return ans;
        for(int i = 0; i < n - 2;) {
            int left = i + 1;
            int right = n - 1;
            while(left < right) {
                if((long)nums[i] * nums[right] > 0) break;
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                }
                if(sum >= 0) {
                    while(left < right && nums[right] == nums[--right]);
                }
                else if(sum < 0) {
                    while(left < right && nums[left] == nums[++left]);
                }
            }
            while(i < n - 2 && nums[i] == nums[++i]);
        }
        return ans;
    }
}
