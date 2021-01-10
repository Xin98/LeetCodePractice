package cn.codexin.questions;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xinGao 2021/1/10
 */

public class Q0228_Summary_Ranges {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new LinkedList<>();
        if(n == 0) {
            return ans;
        }
        int begin = nums[0];
        int end = nums[0];
        for(int i = 1; i <= n; i++) {
            if(i != n && nums[i] == end + 1) {
                end++;
            } else {
                if(begin == end) {
                    ans.add(String.valueOf(begin));
                } else {
                    ans.add(begin + "->" + end);
                }
                if(i != n) {
                    begin = nums[i];
                    end = nums[i];
                }
            }
        }
        return ans;
    }
}
