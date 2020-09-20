package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/9/20
 */

public class Q0078_Subsets {
    private List<List<Integer>> ans;
    private int[] nums;
    private int n;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new LinkedList<>();
        this.nums = nums;
        this.n = nums.length;
        dfs(new LinkedList<>(), 0);
        return ans;
    }
    public void dfs(List<Integer> subset, int idx) {
        if(idx == n) {
            ans.add(new LinkedList<>(subset));
            return;
        }
        dfs(subset, idx + 1);
        subset.add(nums[idx]);
        dfs(subset, idx + 1);
        subset.remove(subset.size() - 1);
    }
}
