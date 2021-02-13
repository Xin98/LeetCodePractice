package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2021/2/13
 */

public class Q0448_Find_All_Numbers_Disappeared_in_an_Array {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            nums[(num - 1) % n] += n;
        }
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(nums[i] <= n) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
