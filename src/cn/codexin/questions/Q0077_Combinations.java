package cn.codexin.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinGao 2020/9/8
 */

public class Q0077_Combinations {
    private List<List<Integer>> ans;
    private int k;
    private int n;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        this.k = k;
        this.n = n;
        dfs(new ArrayList<>(), 1);
        return ans;
    }
    public void dfs(List<Integer> res, int num) {
        if(k - res.size() > n - num + 1) {
            return;
        }
        res.add(num);
        if(res.size() == k) {
            ans.add(new ArrayList<>(res));
        } else {
            dfs(res, num + 1);
        }
        res.remove(res.size()-1);
        dfs(res, num + 1);
    }
}
