package cn.codexin.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2020/9/18
 */

public class Q0047_Permutations_II {
    private int[] nums;
    private List<List<Integer>> ans;
    private boolean[] used;
    private int n;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.n = nums.length;
        ans = new LinkedList<>();
        used = new boolean[n];
        dfs(new LinkedList<>());
        return ans;
    }
    public void dfs(List<Integer> perm) {
        if(perm.size() == n) {
            ans.add(new LinkedList<>(perm));
            return;
        }
        for(int i = 0; i < n; i++) {
            // 回溯的时候前面重复的数字没用过当前不允许用， 去重
            // 这里若使用used[i] || i > 0 && nums[i-1] == nums[i] && used[i-1] 则是另一种去重思路
            if(used[i] || i > 0 && nums[i-1] == nums[i] && !used[i-1]) {
                continue;
            }
            used[i] = true;
            perm.add(nums[i]);
            dfs(perm);
            perm.remove(perm.size() - 1);
            used[i] = false;
        }
    }
}
