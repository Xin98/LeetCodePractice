package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2020/9/10
 */

public class Q0040_Combination_Sum_II {
    private int n;
    private List<List<Integer>> ans;
    private List<int[]> freq;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        if(target == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        freq = new ArrayList<>();
        // 构造频率数组
        for (int num : candidates) {
            int size = freq.size();
            if(size == 0 || freq.get(size - 1)[0] != num) {
                freq.add(new int[] {num, 1});
            } else {
                freq.get(size - 1)[1]++;
            }
        }
        this.n = freq.size();
        dfs(new ArrayList<>(), freq,0, target);
        return ans;
    }

    private void dfs(List<Integer> res, List<int[]> freq, int pos, int target) {
        if(target == 0) {
            ans.add(new ArrayList<>(res));
            return;
        }
        if(pos >= n || target < 0) {
            return;
        }
        dfs(res, freq, pos + 1, target);
        int num = freq.get(pos)[0];
        int most = freq.get(pos)[1];
        for (int i = 1; i <= most; i++) {
            res.add(num);
            dfs(res, freq, pos + 1, target - i * num);
        }
        for (int i = 1; i <= most; i++) {
            res.remove(res.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q0040_Combination_Sum_II Q = new Q0040_Combination_Sum_II();
        Q.combinationSum2(new int[] {2,5,2,1,2}, 5);
    }
}
