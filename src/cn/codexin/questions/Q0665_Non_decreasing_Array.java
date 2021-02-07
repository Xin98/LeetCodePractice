package cn.codexin.questions;

/**
 * Created by xinGao 2021/2/7
 */

public class Q0665_Non_decreasing_Array {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            int x = nums[i];
            int y = nums[i + 1];
            if(x > y) {
                cnt++;
                if(cnt > 1) {
                    return false;
                }
                if(i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }
}
