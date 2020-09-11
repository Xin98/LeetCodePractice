package cn.codexin.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xinGao 2020/9/11
 */

public class Q0216_Combination_Sum_III {
    private List<List<Integer>> ans;
    private List<Integer> tmp;
    private int k;
    private int n;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        tmp = new ArrayList<>();
        this.k = k;
        this.n = n;
        for (int i = 0; i < (1 << 9); i++) {
            check(i);
        }
        return ans;
    }
    public void check(int mask) {
        tmp.clear();
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            if(((1<<i) & mask) != 0) {
                tmp.add(i+1);
                sum += i + 1;
            }
        }
        if(tmp.size() == k && sum == n) {
            ans.add(new ArrayList<>(tmp));
        }
    }

    public static void main(String[] args) {
        System.out.println((0 & 0));
    }
}
