package cn.codexin.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xinGao 2020/10/8
 */

public class Q1296_Divide_Array_in_Sets_of_K_Consecutive_Numbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if(n % k != 0) {
            return false;
        }
        List<int[]> numsCnt = new ArrayList<>();
        Arrays.sort(nums);
        for(int num : nums) {
            if(numsCnt.size() == 0 || numsCnt.get(numsCnt.size() - 1)[0] != num) {
                numsCnt.add(new int[]{num, 1});
            } else {
                numsCnt.get(numsCnt.size() - 1)[1]++;
            }
        }
        int m = numsCnt.size();
        int totalGroup = n / k;
        for(int i = 0; i < m; i++) {
            int num = numsCnt.get(i)[0];
            int cnt = numsCnt.get(i)[1];
            if(cnt == 0) {
                continue;
            } else if(i + k > m) {
                return false;
            }
            for(int j = 1; j < k; j++) {
                if(numsCnt.get(i + j)[0] != num + j) {
                    return false;
                }
                if(numsCnt.get(i + j)[1] < cnt) {
                    return false;
                }
                numsCnt.get(i + j)[1] -= cnt;
            }
            totalGroup -= cnt;
            if(totalGroup == 0) {
                return true;
            }
        }
        return true;
    }
}
