package cn.codexin.questions;

/**
 * Created by xinGao 2020/5/4
 */

public class Q0045_Jump_Game_II {
    public int jump(int[] nums) {
        int len = nums.length;
        if(len <= 1) return 0;
        int left = 1, right = nums[0];
        int ans = 1;
        for(;left <= right;){
            if(right >= len-1) return ans;
            int newRight = 0;
            for(;left <= right;left++){
                newRight = Math.max(newRight, left + nums[left]);
            }
            ans++;
            right = newRight;
        }
        return -1;
    }

    public static void main(String[] args) {
        Q0045_Jump_Game_II q = new Q0045_Jump_Game_II();
        q.jump(new int[]{1,2,3});
    }
}
