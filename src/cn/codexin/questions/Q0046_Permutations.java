package cn.codexin.questions;

import java.util.*;

/**
 * Created by xinGao 2020/4/25
 */

public class Q0046_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new LinkedList<>();
        if (len < 1) return ans;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int[] tmp = new int[nums.length];
        helper(set, ans, 0, tmp);
        return ans;
    }

    public void helper(Set<Integer> set, List<List<Integer>> ans, int count, int[] tmp) {
        if (count == tmp.length) {
            ArrayList<Integer> res = new ArrayList<>();
            for (int num : tmp) {
                res.add(num);
            }
            ans.add(res);
            return;
        }
        Set<Integer> tmpSet = new HashSet<>();
        tmpSet.addAll(set);
        for (Integer num : tmpSet) {
            set.remove(num);
            tmp[count] = num;
            helper(set, ans, count + 1, tmp);
            set.add(num);
        }
    }

    public static void main(String[] args) {
        Q0046_Permutations q0046_permutations = new Q0046_Permutations();
        q0046_permutations.permute(new int[]{1, 2, 3});
    }
}
