package cn.codexin.questions;

/**
 * Created by xinGao 2020/4/17
 */

public class Q0055_Jump_Game {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 0) return false;
        int end = 0;
        for(int i = 0; i < n; i++){
            if(i <= end){
                end = Math.max(end, i + nums[i]);
            }
            else break;
        }
        return end >= n-1;
    }
}
