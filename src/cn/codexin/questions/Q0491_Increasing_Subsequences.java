package cn.codexin.questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xinGao 2020/8/25
 */

public class Q0491_Increasing_Subsequences {
    private List<List<Integer>> ans = new ArrayList<>();
    private Set<Integer> set = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        dfs(nums, tmp, 0, nums.length - 1);
        return ans;
    }
    public void dfs(int[] nums, List<Integer> tmp, int begin, int end) {
        if(tmp.size() >= 2) {
            ans.add(new ArrayList<>(tmp));
        }
        Set<Integer> set = new HashSet<>();
        for(int i = begin; i <= end; i++) {
            if(set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            if(tmp.isEmpty() || tmp.get(tmp.size()-1) <= nums[i]) {
                tmp.add(nums[i]);
                dfs(nums, tmp, i + 1, end);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

}
