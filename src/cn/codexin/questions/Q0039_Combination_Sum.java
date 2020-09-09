package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2020/9/9
 */

public class Q0039_Combination_Sum {
    private List<List<Integer>> ans;
    private int n;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(target == 0) {
            return ans;
        }
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        this.n = candidates.length;
        dfs(new ArrayList<>(), candidates, 0, 0, target);
        return ans;
    }
    public void dfs(List<Integer> res, int[] candidates, int index, int sum, int target) {
        if(sum > target || index >= n) {
            return;
        }
        if(sum == target) {
            ans.add(new ArrayList<>(res));
            return;
        }
        res.add(candidates[index]);
        // 重复选当前数字
        dfs(res, candidates, index, sum + candidates[index], target);
        res.remove(res.size() - 1);
        // 不选当前数字
        dfs(res, candidates, index + 1, sum, target);
    }

    public static void main(String[] args) {
        Q0039_Combination_Sum Q = new Q0039_Combination_Sum();
        Q.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}
