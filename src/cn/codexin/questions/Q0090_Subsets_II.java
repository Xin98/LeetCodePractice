package cn.codexin.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2021/3/31
 */

public class Q0090_Subsets_II {

    private List<List<Integer>> ans;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new LinkedList<>();
        int n = nums.length;
        Arrays.sort(nums);
        dfs(new LinkedList<>(), nums, 0, n, false);
        return ans;
    }
    public void dfs(List<Integer> tmp, int[] nums, int pos, int n, boolean choosePre){
        if(pos == n) {
            ans.add(new LinkedList<>(tmp));
            return;
        }
        dfs(tmp, nums, pos + 1, n, false);
        if(!choosePre && pos > 0 && nums[pos] == nums [pos - 1]) {
            return;
        }
        tmp.add(nums[pos]);
        dfs(tmp, nums, pos + 1, n, true);
        tmp.remove(tmp.size() - 1);
    }
}
